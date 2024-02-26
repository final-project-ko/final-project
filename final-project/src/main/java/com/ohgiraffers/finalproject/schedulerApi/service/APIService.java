package com.ohgiraffers.finalproject.schedulerApi.service;

import com.ohgiraffers.finalproject.schedulerApi.article.Article;
import com.ohgiraffers.finalproject.schedulerApi.entity.ApiEntity;
import com.ohgiraffers.finalproject.schedulerApi.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class APIService {

    @Autowired
    APIRepository apiRepository;

    public Object headLine(List<Article> headLine, String keyName) {

        if (headLine == null || headLine.isEmpty()) {
            System.out.println("api 만료");
            return new String("api키가 응답하지 않습니다.");
        }

        List<ApiEntity> allInsertNews = new ArrayList<>();

        // 다 잘 넘어오는지 확인하는 int
        int num = 0;

        for (Article article : headLine) {
            int entity = createEntity(article, keyName);
            num = entity;
            if (num > 0) {

            } else {
                System.out.println("에러 발생");
            }

        }
        return new String("성공적으로 수행 되었습니다.");



    }

    public int createEntity(Article article, String keyName) {

        ApiEntity entity = new ApiEntity();
        entity.setCategoryName(keyName);
        entity.setTitle(article.getTitle());
        entity.setDescription(article.getDescription());
        entity.setUrl(article.getUrl());
        entity.setUrlToImage(article.getUrlToImage());
        entity.setDate(LocalDate.now());

        // 요약내용이나 이미지가 비어있으면 등록하지 않음
        if (entity.getDescription().equals("null") || entity.getUrlToImage().equals("null") ||
                entity.getDescription().isEmpty() || entity.getUrlToImage().isEmpty() || entity.getDescription().contains("�")) {
            System.out.println(entity.getTitle() + " 기사는 등록되지 않았습니다. (요약내용 또는 이미지가 없음)");
            return 0;

        } else {
            apiRepository.save(entity);
            return 1;

        }


    }


}
