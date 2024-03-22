// 커넥션 확인 후, Python에 인공지능 가공 요청을 보내는 서비스 코드

package com.ohgiraffers.finalproject.news.pythonconnect.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.repository.KeywordNewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.repository.SummaryNewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import com.ohgiraffers.finalproject.news.pythonconnect.statumanager.ConnectionStatusManager;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;



@EnableAsync
@Service
public class ConnectionPythonApi {

    private final RestTemplate restTemplate;
    private final NewsService newsService;
    private final ConnectionStatusManager connectionStatusManager; // Python 서버와의 연결 상태
    private final KeywordNewsRepository keywordNewsRepository; // keyword상태
    private final SummaryNewsRepository summaryNewsRepository; //summary상태
    private final Executor taskExecutor;


    @Autowired
    public ConnectionPythonApi(RestTemplate restTemplate, NewsService newsService, ConnectionStatusManager connectionStatusManager, KeywordNewsRepository keywordNewsRepository, SummaryNewsRepository summaryNewsRepository, Executor taskExecutor) {
        this.restTemplate = restTemplate;
        this.newsService = newsService;
        this.connectionStatusManager = connectionStatusManager;
        this.keywordNewsRepository = keywordNewsRepository;
        this.summaryNewsRepository = summaryNewsRepository;
        this.taskExecutor = taskExecutor;
    }

//    ======= ai 뉴스 설명 api 요청 전송하는 코드
    @Async("taskExecutor") // 비동기 작업으로 진행
    @Scheduled(fixedRate = 3600000) // 1시간에 한번씩 재요청
    public void AIdescriptionNews() {
        if (!connectionStatusManager.isConnectedToPythonServer()) {
            return;
        }

        List<NewsDTO> newsList = newsService.findAllNewsWithEmptyAiDescription();


        if (!newsList.isEmpty()) {
            CompletableFuture<?>[] futures = newsList.stream()
                    .map(news -> CompletableFuture.runAsync(() -> sendNewsToPythonServer(news, "http://112.222.187.244:8089/receive-news"), taskExecutor))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(futures).join();

        } else {
            System.out.println("[!] 뉴스 데이터가 없습니다. 다음 확인 예정 시간은 1시간 후 입니다.");
        }
    }

//    ======= ai 뉴스 번역 api 요청 전송하는 코드
    @Async("taskExecutor") // 비동기 작업으로 진행
    @Scheduled(fixedRate = 3300000) // 1시간(-5분) 한번씩 재요청
    public void TranslationNews() {
        if (!connectionStatusManager.isConnectedToPythonServer()) {
            return;
        }
        List<NewsDTO> newsList = newsService.findAllNewsWithUnEmptyAiDescription();

        if (!newsList.isEmpty()) {
            CompletableFuture<?>[] futures = newsList.stream()
                    .map(news -> CompletableFuture.runAsync(() -> sendNewsToPythonServer(news, "http://112.222.187.244:8089/process-news"), taskExecutor))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(futures).join();

        } else {
            System.out.println("[!] ai 설명이 존재하는 데이터가 없습니다. 다음 확인 예정 시간은 1시간 후 입니다.");
        }
    }


//    ======= 설명, 번역 api 요청전 json으로 데이터 가공
    private void sendNewsToPythonServer(NewsDTO news, String apiUrl) {
        boolean isSuccessful = false;

        for (int attempt = 0; attempt < 2; attempt++) {
            try {
                String response = restTemplate.postForObject(apiUrl, news, String.class);
                isSuccessful = true;
                break;
            } catch (RestClientException e) {
                if (attempt < 1) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.out.println("[!] 대기 중 인터럽트 발생!");
                    }
                }
            }
        }
        if (!isSuccessful) {
            System.out.println("[!] 두 번의 시도 후에도 Python 서버로 데이터 전송에 실패했습니다. 다음 데이터로 넘어갑니다.");
            connectionStatusManager.checkConnection();
        }
    }

//    ======= 키워드 뉴스 제작 전 가공
    @Async("taskExecutor")
    @Scheduled(cron = "0 5 1 * * ?") //(매일 5분 1시)
    public void resetAndSendKeywordNews() {
        newsService.deleteKeywordNews();
        newsService.CodeNumberKeywordNews();
        KeywordNews();
    }

//    ======= 키워드 뉴스 제작 api 요청 전송하는 코드
    public void KeywordNews() {
        if (!connectionStatusManager.isConnectedToPythonServer()) {
            return;
        }
        String allNewsTitles = newsService.findAllNewsTitlesConcatenated();
        Integer keywordNewsCode = newsService.findKeywordNews(1).getKeywordNewsCode();

        if (!allNewsTitles.isEmpty()) {
            sendNewsTitlesToPythonServer(allNewsTitles, keywordNewsCode, "http://112.222.187.244:8089/keyword-news");
        } else {
            System.out.println("[!] ai 설명이 존재하는 데이터가 없습니다. 다음 확인 예정 시간은 1시간 후 입니다.");
        }
    }

//    ======= 키워드 뉴스 api요청 전 json으로 데이터 가공
    private void sendNewsTitlesToPythonServer(String newsTitles, Integer keywordNewsCode, String apiUrl) {
        boolean isSuccessful = false;

        for (int attempt = 0; attempt < 2; attempt++) {
            try {
                JSONObject jsonPayloadObj = new JSONObject();
                jsonPayloadObj.put("titles", newsTitles);
                jsonPayloadObj.put("keywordNewsCode", keywordNewsCode);

                String jsonPayload = jsonPayloadObj.toString();

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<String> entity = new HttpEntity<>(jsonPayload, headers);

                String response = restTemplate.postForObject(apiUrl, entity, String.class);

                isSuccessful = true;

                break;
            } catch (RestClientException e) {
                if (attempt < 1) {
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.out.println("[!] 대기 중 인터럽트 발생!");
                    }
                }
            }
        }
        if (!isSuccessful) {
            System.out.println("[!] 두 번의 시도 후에도 Python 서버로 데이터 전송에 실패했습니다. 다음 데이터로 넘어갑니다.");
            connectionStatusManager.checkConnection();
        }
    }



//    ======= 요약 뉴스 제작 전 가공
    @Async("taskExecutor")
    @Scheduled(cron = "0 10 1 * * ?") //(매일 10분 1시)
    public void resetAndSendSummaryNews() {
        newsService.deleteSummaryNews();
        newsService.CodeNumberSummaryNews();
        SummaryNews();
    }


//    ======= 요약 뉴스 제작 api 요청 전송하는 코드
    public void SummaryNews() {
        if (!connectionStatusManager.isConnectedToPythonServer()) {
            return;
        }

        List<String> newsTitleChunks = newsService.findAllNewsTitlesSplitIntoChunks();
        Integer summaryNewsCode = newsService.findSummaryNews(1).getSummaryNewsCode();

        if (!newsTitleChunks.isEmpty()) {
            for (String newsChunk : newsTitleChunks) {
                sendNewsToPythonServerSummary(newsChunk, summaryNewsCode, "http://112.222.187.244:8089/summary-news");
            }
        } else {
            System.out.println("[!] 요약할 뉴스 데이터가 없습니다. 다음 확인 예정 시간은 1시간 후입니다.");
        }
    }


//    ======= 요약 뉴스 api요청 전 json으로 데이터 가공
    private void sendNewsToPythonServerSummary(String newsChunk, Integer summaryNewsCode, String apiUrl) {
        RestTemplate restTemplate = new RestTemplate();
        boolean isSuccessful = false;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> map = new HashMap<>();
        map.put("newsChunk", newsChunk);
        map.put("summaryNewsCode", summaryNewsCode);
        String jsonBody = new JSONObject(map).toString();

        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);


        for (int attempt = 0; attempt < 2; attempt++) {
            try {
                String response = restTemplate.postForObject(apiUrl, entity, String.class);
                isSuccessful = true;
                break;
            } catch (RestClientException e) {
                if (attempt < 1) {
                    try {
                        Thread.sleep(30000); // 재시도 전 30초 대기
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.out.println("[!] 대기 중 인터럽트 발생!");
                    }
                }
            }
        }
        if (!isSuccessful) {
            System.out.println("[!] 두 번의 시도 후에도 Python 서버로 데이터 전송에 실패했습니다. 다음 데이터로 넘어갑니다.");
            connectionStatusManager.checkConnection();
        }
    }
}
