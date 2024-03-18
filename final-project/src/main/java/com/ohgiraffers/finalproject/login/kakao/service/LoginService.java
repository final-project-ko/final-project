package com.ohgiraffers.finalproject.login.kakao.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoTokenDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.kakao.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {

    @Autowired
    LoginRepository kakaoRepository;

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

    @Value("${redirect-uri-app}")
    private String KAKAO_REDIRECT_URI_APP;


    public UserEntity getAccessToken(String code, String webApp) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // Http Response Body 객체 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", KAKAO_CLIENT_ID);
        if (webApp == null||webApp.isEmpty()){
            params.add("redirect_uri", KAKAO_REDIRECT_URI_APP);
        }else{
            params.add("redirect_uri", KAKAO_REDIRECT_URI);
        }
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
       //  System.out.println("accessTokenResponse :::::::::::::::" + accessTokenResponse);  //잘받아옴 확인
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

            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(String.valueOf(id));
            userEntity.setUserName(name);
            userEntity.setUserEmail(email);
            userEntity.setAccessToken(kakaoTokenDTO.getAccess_token());
             if(id==-928834404){
                 userEntity.setUserAuth("admin");
             }else {
                 userEntity.setUserAuth("user");
             }
            kakaoRepository.save(userEntity);



        UserEntity userEntitys = kakaoRepository.findByUserId(String.valueOf(id));

        if (userEntitys==null){
            return null;
        }

        return userEntitys;

    }

    public KakaoProfileDTO kakaoLogin(String accessToken) {

        if(accessToken.isEmpty()){
            return null;
        }
        UserEntity profile = kakaoRepository.findByAccessToken(accessToken);

        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
        kakaoProfileDTO.setId(profile.getUserId());
        kakaoProfileDTO.setName(profile.getUserName());
        kakaoProfileDTO.setEmail(profile.getUserEmail());
        kakaoProfileDTO.setUserAuth(profile.getUserAuth());


        return kakaoProfileDTO;
    }
}
