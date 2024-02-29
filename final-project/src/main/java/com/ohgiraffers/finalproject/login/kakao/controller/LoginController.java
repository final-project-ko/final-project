package com.ohgiraffers.finalproject.login.kakao.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.ohgiraffers.finalproject.login.kakao.dto.KakaoProfileDTO;
import com.ohgiraffers.finalproject.login.kakao.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/*")
public class LoginController {

    @Autowired
    private LoginService loginService;




    @RequestMapping("/oauth/*")
    public KakaoProfileDTO kakaoLogin(HttpServletRequest request) throws JsonProcessingException {
        String code = request.getParameter("code");
        KakaoProfileDTO profile = loginService.getAccessToken(code);

        return profile;
    }

}
