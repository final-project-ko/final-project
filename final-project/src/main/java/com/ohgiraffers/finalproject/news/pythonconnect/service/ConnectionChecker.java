// Python 서버와의 연결 상태를 주기적으로 확인하고, 그 상태를 기록하는 클래스
// 정해진 시간 간격으로(30분) Python 서버와의 연결을 시도하고, 연결 상태에 따라 로그를 출력하거나 상태를 업데이트합니다.

package com.ohgiraffers.finalproject.news.pythonconnect.service;

import com.ohgiraffers.finalproject.news.pythonconnect.statumanager.ConnectionStatusManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



@Service
public class ConnectionChecker {

    private final RestTemplate restTemplate;
    private final ConnectionStatusManager connectionStatusManager;
    private final ConnectionPythonApi connectionPythonApi;
    private boolean isConnectedPreviously = false;

    @Autowired
    public ConnectionChecker(RestTemplate restTemplate, ConnectionStatusManager connectionStatusManager, ConnectionPythonApi connectionPythonApi) {
        this.restTemplate = restTemplate;
        this.connectionStatusManager = connectionStatusManager;
        this.connectionPythonApi = connectionPythonApi;
    }

    // 정해진 시간마다 Python 서버의 연결 상태를 확인
    @Scheduled(fixedRate = 600000) // 10분에 한번씩 확인
    public void checkPythonConnection() {
        String pythonApiUrl = "http://112.222.187.244:8089/java-connection-test";
        handleConnectionCheck(pythonApiUrl);
    }

    // Python 서버와의 연결 상태를 확인하고 상태를 관리하는 메소드
    private void handleConnectionCheck(String apiUrl) {
        try {
            // REST API 호출을 통해 Python 서버와의 연결 상태 확인
            String response = restTemplate.getForObject(apiUrl, String.class);
            if (!isConnectedPreviously) {
                connectionPythonApi.AIdescriptionNews();
                connectionPythonApi.AIdescriptionNews();
                isConnectedPreviously = true;
            }
            // 연결 상태를 true로 설정
            connectionStatusManager.setConnectedToPythonServer(true);
        } catch (RestClientException e) {
            // 연결 실패 시 로그 출력 및 연결 상태 업데이트
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedNow = now.format(formatter);
            System.out.println("[!] python서버와 연결되어 있지 않습니다. " + formattedNow);
            connectionStatusManager.setConnectedToPythonServer(false);
            isConnectedPreviously = false;
        }
    }
}