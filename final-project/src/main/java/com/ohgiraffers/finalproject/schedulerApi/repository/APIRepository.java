package com.ohgiraffers.finalproject.schedulerApi.repository;

import com.ohgiraffers.finalproject.schedulerApi.entity.ApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository extends JpaRepository<ApiEntity,Integer> {



}
