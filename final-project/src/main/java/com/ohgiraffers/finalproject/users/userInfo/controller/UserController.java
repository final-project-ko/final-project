package com.ohgiraffers.finalproject.users.userInfo.controller;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.users.userInfo.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "유저 정보", description = "DB에 담긴 유저 정보 api 입니다.")
@RestController
@RequestMapping("/api/user/*")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/admin")
    public List<UserEntity> adminUserInfo(){
        List<UserEntity> userInfo = userService.adminUserInfo();

        return userInfo;
    }

}
