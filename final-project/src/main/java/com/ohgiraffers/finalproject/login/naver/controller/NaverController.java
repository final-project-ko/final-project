package com.ohgiraffers.finalproject.login.naver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.naver.service.NaverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/naver/*")
public class NaverController {

    @Autowired
    private NaverService naverService;

    @Operation(summary = "네이버 로그인 메소드", description = "sns 네이버 로그인 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @RequestMapping("/oauth/*")
    public UserEntity naverLogin(HttpServletRequest request) throws JsonProcessingException {
        String code = request.getParameter("code");
      //   System.out.println(code);
        UserEntity profile = naverService.getAccessToken(code);

        /*테스트 코드 작성해야 함*/

        return profile;

    }

    @PostMapping("/login")
    public KakaoProfileDTO checkNaver(@RequestBody HashMap<String,String> token){

        if (Objects.isNull(token)){
            return null;
        }
        String accessToken = token.get("accessToken");

        KakaoProfileDTO profile = naverService.naverLogin(accessToken);
        return profile;
    }
}
