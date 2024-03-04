package com.ohgiraffers.finalproject.users.userInfo.service;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.users.userInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<UserEntity> adminUserInfo() {

        List<UserEntity> allUsers = userRepository.findAll();

        if (allUsers.isEmpty()){
            System.out.println("유저 정보가 없습니다.");
            return null;
        }

        return allUsers;

    }
}
