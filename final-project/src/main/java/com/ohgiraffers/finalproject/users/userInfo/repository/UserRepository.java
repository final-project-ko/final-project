package com.ohgiraffers.finalproject.users.userInfo.repository;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.schedulerApi.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    List<UserEntity> findAll();


}
