package com.ohgiraffers.finalproject.news.category.contents.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.KeywordNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.SummaryNewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.entity.KeywordNews;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.entity.SummaryNews;
import com.ohgiraffers.finalproject.news.category.contents.repository.KeywordNewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.repository.NewsRepository;
import com.ohgiraffers.finalproject.news.category.contents.repository.SummaryNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private KeywordNewsRepository keywordNewsRepository;

    @Autowired
    private SummaryNewsRepository summaryNewsRepository;



//    ======= 뉴스 DB정보 리스트로 작성
    public List<NewsDTO> findAllNews() {

        return newsRepository.findAll()
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    newsDTO.setCode(news.getCode());
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getDescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setAidescription(news.getAidescription()); // 03.12 ai컬럼 추가
                    newsDTO.setTransdescription(news.getTransdescription()); // 03.15 ai한글번역 컬럼 추가
                    newsDTO.setDate(news.getDate());

                    return newsDTO; // newsDTO 반환
                })
                .toList(); // newsRepository를 통해 모든 news를 찾아서 반환
    }

//    ======= 카테고리 뉴스 DB정보 리스트로 작성
    public List<NewsDTO> categoryNews(String category, LocalDate date) {
        return newsRepository.findByCategoryAndDate(category, date)
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO();
                    newsDTO.setCode(news.getCode() != null ? news.getCode() : 0); // getCode()가 null이면 0으로 설정
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getAidescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setAidescription(news.getAidescription()); // 03.12 ai컬럼 추가
                    newsDTO.setTransdescription(news.getTransdescription()); // 03.15 ai한글번역 컬럼 추가
                    newsDTO.setDate(news.getDate());

                    return newsDTO;
                })
                .toList();
    }

//    ======= 전체뉴스 정보 수정
    public News modifyNews(HashMap<String, String> news) {
        News modifyNews = new News();
        modifyNews.setCode(Integer.parseInt(news.get("code")));
        modifyNews.setTitle(news.get("title"));
        modifyNews.setAidescription(news.get("description"));
        modifyNews.setUrl(news.get("url"));
        modifyNews.setImage(news.get("image"));
        modifyNews.setCategory(news.get("category"));

        // "date" 필드가 있는지 확인하고, 없으면 현재 날짜로 설정
        if (news.containsKey("date")) {
            try {
                modifyNews.setDate(LocalDate.parse(news.get("date")));
            } catch (DateTimeParseException e) {
                // 날짜 포맷이 잘못되었을 경우 예외 처리
                System.err.println("날짜 포맷이 잘못되었습니다. 기본값으로 현재 날짜를 설정합니다.");
                modifyNews.setDate(LocalDate.now());
            }
        } else {
            // "date" 필드가 없을 경우 현재 날짜로 설정
            modifyNews.setDate(LocalDate.now());
        }

        modifyNews.setAidescription(news.get("aidescription")); // 03.12 ai컬럼 추가
        modifyNews.setTransdescription(news.get("transdescription")); // 03.15 ai한글번역 컬럼 추가

        News modify = newsRepository.save(modifyNews);

        return modify;
    }

//    ======= 전체뉴스 삭제
    public News deleteNews(HashMap<String, String> news) {

        News deleteNews = new News();
        deleteNews.setCode(Integer.parseInt(news.get("code")));
        deleteNews.setTitle(news.get("title"));

        News delete = newsRepository.save(deleteNews);

        return delete;
    }


//    ======= Keyword 뉴스 DB정보 작성 (KeywordNewsCode int형태로 호출)
    public KeywordNewsDTO findKeywordNews(int num) {
        KeywordNews keywordNews = keywordNewsRepository.findByKeywordNewsCode(num);

        KeywordNewsDTO keywordNewsDTO = new KeywordNewsDTO();
        keywordNewsDTO.setKeywordNewsCode(keywordNews.getKeywordNewsCode());
        keywordNewsDTO.setKeyword1(keywordNews.getKeyword1());
        keywordNewsDTO.setKeyword2(keywordNews.getKeyword2());
        keywordNewsDTO.setKeyword3(keywordNews.getKeyword3());
        keywordNewsDTO.setKeyword4(keywordNews.getKeyword4());
        keywordNewsDTO.setKeyword5(keywordNews.getKeyword5());
        keywordNewsDTO.setKeyword6(keywordNews.getKeyword6());
        keywordNewsDTO.setKeyword7(keywordNews.getKeyword7());
        keywordNewsDTO.setKeyword8(keywordNews.getKeyword8());
        keywordNewsDTO.setKeyword9(keywordNews.getKeyword9());
        keywordNewsDTO.setKeyword10(keywordNews.getKeyword10());
        keywordNewsDTO.setKeyword11(keywordNews.getKeyword11());
        keywordNewsDTO.setKeyword12(keywordNews.getKeyword12());
        keywordNewsDTO.setKeyword13(keywordNews.getKeyword13());
        keywordNewsDTO.setKeyword14(keywordNews.getKeyword14());
        keywordNewsDTO.setKeyword15(keywordNews.getKeyword15());
        keywordNewsDTO.setDate(keywordNews.getDate());
        return keywordNewsDTO;

    }

//    ======= Summary 뉴스 DB정보 작성 (SummaryNewsCode int형태로 호출)
    public SummaryNewsDTO findSummaryNews(int num) {
        SummaryNews summaryNews = summaryNewsRepository.findBySummaryNewsCode(num);
       // System.out.println(summaryNews);
        SummaryNewsDTO summaryNewsDTO = new SummaryNewsDTO();
        summaryNewsDTO.setSummaryNewsCode(summaryNews.getSummaryNewsCode());
        summaryNewsDTO.setSummary1(summaryNews.getSummary1());
        summaryNewsDTO.setSummary2(summaryNews.getSummary2());
        summaryNewsDTO.setSummary3(summaryNews.getSummary3());
        summaryNewsDTO.setSummary4(summaryNews.getSummary4());
        summaryNewsDTO.setSummary5(summaryNews.getSummary5());
        summaryNewsDTO.setDate(summaryNews.getDate());
        return summaryNewsDTO;
    }



//    ======= ai_description이 비어있는 뉴스 데이터를 찾는 메서드
    public List<NewsDTO> findAllNewsWithEmptyAiDescription() {
        // 뉴스 데이터를 모두 가져온 후, ai_description이 비어있는 데이터만 필터링하고 날짜 기준으로 내림차순 정렬
        return newsRepository.findAll().stream()
                .filter(news -> news.getAidescription() == null || news.getAidescription().isEmpty())
                .sorted(Comparator.comparing(News::getDate).reversed())
                .map(news -> new NewsDTO(news))
                .collect(Collectors.toList());
    }


//    ======= ai_description이 비어 있지 않은 뉴스를 찾는 메서드
    public List<NewsDTO> findAllNewsWithUnEmptyAiDescription() {
        // 영어 카테고리만 호출
        Set<String> categories = Set.of(
                "us_total",
                "us_business",
                "us_entertainment",
                "us_general",
                "us_health",
                "us_science",
                "us_sports",
                "us_technology"
        );
        // 뉴스 데이터를 모두 가져온 후, ai_description이 비어있지 않은 데이터만 필터링하고 날짜 기준으로 내림차순 정렬
        return newsRepository.findAll().stream()
                .filter(news -> news.getAidescription() != null && !news.getAidescription().isEmpty())
                .filter(news -> categories.contains(news.getCategory()))
                .sorted(Comparator.comparing(News::getDate).reversed())
                .map(news -> new NewsDTO(news))
                .collect(Collectors.toList());
    }


//    ======= 키워드 뉴스 api전달 전 title 1000자로 병합
    public String findAllNewsTitlesConcatenated() {
        List<News> newsList = newsRepository.findAll();
        // 한글 카테고리만 호출
        Set<String> categories = Set.of(
                "kr_total",
                "kr_business",
                "kr_entertainment",
                "kr_general",
                "kr_health",
                "kr_science",
                "kr_sports",
                "kr_technology"
        );
        // 뉴스 리스트를 랜덤으로 섞음
        Collections.shuffle(newsList);

        // 랜덤으로 섞인 뉴스에서, 지정된 카테고리에 속하는 뉴스의 제목만 추출하여 공백을 기준으로 모든 제목을 하나의 문자열로 병합
        String titles = newsList.stream()
                .filter(news -> categories.contains(news.getCategory())) // 카테고리 필터링
                .map(News::getTitle) // 컬럼: title만 호출
                .collect(Collectors.joining(" ")); // 공백을 기준으로 모든 제목을 하나의 문자열로 병합

        // 최대 500자로 제한
        if (titles.length() > 500) {
            return titles.substring(0, 500);
        } else {
            return titles;
        }
    }


//    ======= 요약 뉴스 api전달 전 title 병합
    public List<String> findAllNewsTitlesSplitIntoChunks() {
        List<News> newsList = newsRepository.findAll();
        Set<String> categories = Set.of(
                "kr_total",
                "kr_business",
                "kr_entertainment",
                "kr_general",
                "kr_health",
                "kr_science",
                "kr_sports",
                "kr_technology"
        );

        // 뉴스 리스트를 랜덤으로 섞음
        Collections.shuffle(newsList);

        // 랜덤으로 섞인 뉴스에서, 지정된 카테고리에 속하는 뉴스의 제목만 추출하여 공백을 기준으로 모든 제목을 하나의 문자열로 병합
        String titles = newsList.stream()
                .filter(news -> categories.contains(news.getCategory())) // 카테고리 필터링
                .sorted(Comparator.comparing(News::getDate).reversed()) // 최근 날짜부터 호출
                .map(News::getTitle) // 컬럼: title만 호출
                .collect(Collectors.joining(" ")); // 공백을 기준으로 모든 제목을 하나의 문자열로 병합

        // 최대 10000자로 제한
        titles = titles.length() > 10000 ? titles.substring(0, 10000) : titles;

        // 500자 단위로 나누어 리스트 생성 (총 20개 생성)
        List<String> chunks = new ArrayList<>();
        int index = 0;
        while (index < titles.length()) {
            chunks.add(titles.substring(index, Math.min(index + 500, titles.length())));
            index += 500;
        }
        return chunks;
    }


//    ======= 키워드 뉴스 삭제
    public void deleteKeywordNews() {
        keywordNewsRepository.deleteAll();
        System.out.println("[!] 모든 KeywordNews 데이터가 삭제되었습니다.");
    }

//    ======= 키워드 뉴스에 로우(codeNumber 1) 추가
    public void CodeNumberKeywordNews() {
        KeywordNews keywordNews = new KeywordNews();
        keywordNews.setKeywordNewsCode(1);
        keywordNewsRepository.save(keywordNews);
    }


//    ======= 요약 뉴스 삭제
    public void deleteSummaryNews() {
        summaryNewsRepository.deleteAll();
        System.out.println("[!] 모든 SummaryNews 데이터가 삭제되었습니다.");
    }

//    ======= 요약 뉴스에 로우(codeNumber 1) 추가
    public void CodeNumberSummaryNews() {
        SummaryNews summaryNews = new SummaryNews();
        summaryNews.setSummaryNewsCode(1);
        summaryNewsRepository.save(summaryNews);
    }


}
