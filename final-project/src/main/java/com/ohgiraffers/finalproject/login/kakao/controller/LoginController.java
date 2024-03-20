package com.ohgiraffers.finalproject.login.kakao.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.login.kakao.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;

@Tag(name = "유저 정보", description = "유저 관련 api 입니다.")
@RestController
@RequestMapping("/api/login/*")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @Operation(summary = "카카오 회원 가입 메소드", description = "sns 카카오 회원 가입 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/oauth/*")
    public UserEntity kakaoLogin(@RequestParam("code") String code, @RequestParam(value = "name", required = false) String name) throws JsonProcessingException  {
        if (code.isEmpty()){
            return null;
        }
        UserEntity profile = loginService.getAccessToken(code,name);

        /*테스트 코드 작성해야 함*/
        if (profile==null){
            return null;
        }

        return profile;
    }

    @Operation(summary = "카카오 토큰 로그인 메소드", description = "sns 카카오 토큰 로그인 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/kakao")
    public KakaoProfileDTO checkKakao(@RequestBody HashMap<String,String> token){

        if (Objects.isNull(token)){
            return null;
        }
        String accessToken = token.get("accessToken");

        KakaoProfileDTO profile = loginService.kakaoLogin(accessToken);
        return profile;
    }

}
