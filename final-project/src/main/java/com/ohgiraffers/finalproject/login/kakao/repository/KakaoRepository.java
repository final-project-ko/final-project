package com.ohgiraffers.finalproject.login.kakao.repository;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KakaoRepository  extends JpaRepository<UserEntity, Integer> {


    UserEntity findByUserId(int id);
}
