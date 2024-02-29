package com.ohgiraffers.finalproject.login.kakao.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoTokenDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.kakao.repository.KakaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    KakaoRepository kakaoRepository;

    @Value("${client-id}")
    private String KAKAO_CLIENT_ID;
    @Value("${client-secret}")
    private String KAKAO_CLIENT_PWD;
    @Value("${redirect-uri}")
    private String KAKAO_REDIRECT_URI;
    @Value("${token_uri}")
    private String KAKAO_TOKEN_URI;
    @Value("${user-info-uri}")
    private String KAKAO_USER_INFO;


    public UserEntity getAccessToken(String code) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // Http Response Body 객체 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", KAKAO_CLIENT_ID);
        params.add("redirect_uri", KAKAO_REDIRECT_URI);
        params.add("code",code);
        params.add("client_secret",KAKAO_CLIENT_PWD);

        // 헤더와 바디 합치기 위해 Http Entity 객체 생성
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params,headers);

        // 카카오로부터 Access token 받아오기
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> accessTokenResponse = rt.exchange(
                KAKAO_TOKEN_URI,
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );
        System.out.println("accessTokenResponse :::::::::::::::" + accessTokenResponse);  //잘받아옴 확인
        // JSON Parsing (-> KakaoTokenDto)
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        KakaoTokenDTO kakaoTokenDTO = new KakaoTokenDTO();

        try {
            kakaoTokenDTO = objectMapper.readValue(accessTokenResponse.getBody(),kakaoTokenDTO.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
/*        System.out.println("getAccess_token :::::::::::::::" +kakaoTokenDTO.getAccess_token());
        System.out.println("getRefresh_token :::::::::::::::" +kakaoTokenDTO.getRefresh_token());*/


        // 회원 프로필 조회 끝 (인증)
        RestTemplate rt2 = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+kakaoTokenDTO.getAccess_token());
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity response = rt2.exchange(
                KAKAO_USER_INFO,
                HttpMethod.POST,
                request,
                String.class
        );

        ObjectMapper objectMapper1 = new ObjectMapper();

            JsonNode jsonNode = objectMapper1.readTree((String)response.getBody());
            int id = jsonNode.path("id").asInt();
            String name = jsonNode.path("kakao_account").path("name").asText();
            String email = jsonNode.path("kakao_account").path("email").asText();
/*        System.out.println("id:::::::::" + id);
        System.out.println(name);
        System.out.println(email);*/
        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO(id,name,email);






     // 아이디 확인   System.out.println("kakaoProfileDTO.getId():::::::::::::::::::::"+kakaoProfileDTO.getId());



        UserEntity userOptional = kakaoRepository.findByUserId(kakaoProfileDTO.getId());


        if(ObjectUtils.isEmpty(userOptional)){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId( kakaoProfileDTO.getId());
            userEntity.setUserName(kakaoProfileDTO.getName());
            userEntity.setUserEmail(kakaoProfileDTO.getEmail());
            userEntity.setUserAuth("user");
            kakaoRepository.save(userEntity);

        }

        UserEntity userEntity = kakaoRepository.findByUserId(kakaoProfileDTO.getId());
        System.out.println(userEntity);

        return userEntity;

    }

    public ResponseEntity kakaoLogin(String accessToken) {
        return null;
    }
}
