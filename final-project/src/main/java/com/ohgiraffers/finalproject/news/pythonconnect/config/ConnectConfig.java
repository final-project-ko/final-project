//애플리케이션 전역에서 RestTemplate 인스턴스를 사용할 수 있게 해줌

package com.ohgiraffers.finalproject.news.pythonconnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class ConnectConfig {

    // Spring 컨테이너에 Bean으로 등록
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}