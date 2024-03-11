package com.ohgiraffers.finalproject.users.userInfo.service;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.users.userInfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> findAllUsers() {
        int kakao = 0;
        int naver = 0;
        List<UserEntity> allUsers = userRepository.findAll();
        Map<String,Integer> userCounts = new HashMap<>();

        if (allUsers.isEmpty()){
            System.out.println("유저 정보가 없습니다.");
            return null;
        }
        for (UserEntity user:allUsers) {
            try {
                long id = Long.parseLong(user.getUserId());
                kakao++;
            }catch (NumberFormatException e){
                naver++;
            }
        }
        userCounts.put("kakao",kakao);
        userCounts.put("naver",naver);

        return userCounts;
    }
}
