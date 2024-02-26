package com.ohgiraffers.finalproject.news.category.contents.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsDTO> findAllNews() {

        return newsRepository.findAll()
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO(); // newsDTO 생성 후 news의 내용을 newDTO에 저장
                    newsDTO.setCode(news.getCode());
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getDescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setDate(news.getDate());

                    return newsDTO; // newsDTO 반환
                })
                .toList(); // newsRepository를 통해 모든 news를 찾아서 반환
    }

    public List<NewsDTO> categoryNews(String category, LocalDate date) {

        return newsRepository.findByCategoryAndDate(category, date)
                .stream()
                .map(news -> {
                    NewsDTO newsDTO = new NewsDTO();
                    newsDTO.setCode(news.getCode());
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getDescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setDate(news.getDate());

                    return newsDTO;
                })
                .toList();

    }
}
