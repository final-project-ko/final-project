package com.ohgiraffers.finalproject.login.naver.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoTokenDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.kakao.repository.LoginRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
public class NaverService {

    @Value("${naver_client-id}")
    private String NAVER_CLIENT_ID;
    @Value("${naver_client-secret}")
    private String NAVER_CLIENT_PWD;
    @Value("${naver_redirect-uri}")
    private String NAVER_REDIRECT_URI;
    @Value("${naver_token_uri}")
    private String NAVER_TOKEN_URI;
    @Value("${naver_user-info-uri}")
    private String NAVER_USER_INFO;
    @Value("${naver_uthorization-uri}")
    private String NAVER_AUTH_URI;

    @Autowired
    private LoginRepository loginRepository;

    public UserEntity getAccessToken(String code) throws JsonProcessingException {
        String accessToken = "";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded");

        // Http Response Body 객체 생성
        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", NAVER_CLIENT_ID);
        params.add("redirect_uri", NAVER_REDIRECT_URI);
        params.add("code",code);
        params.add("client_secret",NAVER_CLIENT_PWD);

        // 헤더와 바디 합치기 위해 Http Entity 객체 생성
        HttpEntity<MultiValueMap<String,String>> naverTokenRequest = new HttpEntity<>(params,headers);

        // 카카오로부터 Access token 받아오기
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> accessTokenResponse = rt.exchange(
                NAVER_TOKEN_URI,
                HttpMethod.POST,
                naverTokenRequest,
                String.class
        );
        // System.out.println("accessTokenResponse :::::::::::::::" + accessTokenResponse +":::::::::::::::::");  //잘받아옴 확인

        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject =  (JSONObject)jsonParser.parse(accessTokenResponse.getBody());

            accessToken = (String)jsonObject.get("access_token");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        // 회원 프로필 조회 끝 (인증)
        RestTemplate rt2 = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+accessToken);
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        HttpEntity request = new HttpEntity(httpHeaders);

        ResponseEntity response = rt2.exchange(
                NAVER_USER_INFO,
                HttpMethod.POST,
                request,
                String.class
        );

        ObjectMapper objectMapper1 = new ObjectMapper();

        JsonNode jsonNode = objectMapper1.readTree((String)response.getBody());
        // System.out.println("RESPONSE::::::::::::::::::::::::::::::::"+response);
        String id = jsonNode.path("response").path("id").asText();
        String name = jsonNode.path("response").path("name").asText();
        String email = jsonNode.path("response").path("email").asText();





        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setUserName(name);
        userEntity.setUserEmail(email);
        userEntity.setAccessToken(accessToken);
        if(id=="-928834404"){
            userEntity.setUserAuth("admin");
        }else {
            userEntity.setUserAuth("user");
        }
        loginRepository.save(userEntity);



        UserEntity userEntitys = loginRepository.findByUserId(id);

        return userEntitys;
    }

    public KakaoProfileDTO naverLogin(String accessToken) {

        if(accessToken.isEmpty()){
            return null;
        }
        UserEntity profile = loginRepository.findByAccessToken(accessToken);

        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
        kakaoProfileDTO.setId(profile.getUserId());
        kakaoProfileDTO.setName(profile.getUserName());
        kakaoProfileDTO.setEmail(profile.getUserEmail());
        kakaoProfileDTO.setUserAuth(profile.getUserAuth());


        return kakaoProfileDTO;
    }
}
