package com.ohgiraffers.finalproject.login.naver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.naver.service.NaverService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@Tag(name = "유저 정보", description = "유저 관련 api 입니다.")
@RestController
@RequestMapping("/api/naver/*")
@CrossOrigin(origins = "*")
public class NaverController {

    @Autowired
    private NaverService naverService;

    @Operation(summary = "네이버 회원 가입 메소드", description = "sns 네이버 회원 가입 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/oauth/*")
    public UserEntity naverLogin(HttpServletRequest request) throws JsonProcessingException {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
         System.out.println(name);
        UserEntity profile = naverService.getAccessToken(code,name);

        /*테스트 코드 작성해야 함*/

        return profile;

    }

    @Operation(summary = "네이버 토큰 로그인 메소드", description = "sns 네이버 토큰 로그인 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/login")
    public KakaoProfileDTO checkNaver(@RequestBody HashMap<String,String> token){

        if (Objects.isNull(token)){
            return null;
        }
        String accessToken = token.get("accessToken");
        System.out.println("adsfs"+accessToken);

        KakaoProfileDTO profile = naverService.naverLogin(accessToken);
        return profile;
    }
}
