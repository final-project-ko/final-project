package com.ohgiraffers.finalproject.news.category.contents.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
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
                    newsDTO.setAi_description(newsDTO.getAi_description()); // 2024-03-12 ai컬럼 추가
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
                    newsDTO.setCode(news.getCode() != null ? news.getCode() : 0); // getCode()가 null이면 0으로 설정
                    newsDTO.setTitle(news.getTitle());
                    newsDTO.setCategory(news.getCategory());
                    newsDTO.setDescription(news.getDescription());
                    newsDTO.setUrl(news.getUrl());
                    newsDTO.setImage(news.getImage());
                    newsDTO.setAi_description(newsDTO.getAi_description()); // 2024-03-12 ai컬럼 추가
                    newsDTO.setDate(news.getDate());

                    return newsDTO;
                })
                .toList();
    }

    public News modifyNews(HashMap<String, String> news) {
        News modifyNews = new News();
        modifyNews.setCode(Integer.parseInt(news.get("code")));
        modifyNews.setTitle(news.get("title"));
        modifyNews.setDescription(news.get("description"));
        modifyNews.setUrl(news.get("url"));
        modifyNews.setImage(news.get("image"));
        modifyNews.setCategory(news.get("category"));

        // "date" 필드가 있는지 확인하고, 없으면 현재 날짜로 설정
        if (news.containsKey("date")) {
            try {
                modifyNews.setDate(LocalDate.parse(news.get("date")));
            } catch (DateTimeParseException e) {
                // 날짜 포맷이 잘못되었을 경우 예외 처리
                System.err.println("날짜 포맷이 잘못되었습니다. 기본값으로 현재 날짜를 설정합니다.");
                modifyNews.setDate(LocalDate.now());
            }
        } else {
            // "date" 필드가 없을 경우 현재 날짜로 설정
            modifyNews.setDate(LocalDate.now());
        }

        modifyNews.setAi_description(news.get("ai_description")); // 2024-03-12 ai컬럼 추가

        News modify = newsRepository.save(modifyNews);

        return modify;
    }


    public News deleteNews(HashMap<String, String> news) {

        News deleteNews = new News();
        deleteNews.setCode(Integer.parseInt(news.get("code")));
        deleteNews.setTitle(news.get("title"));

        News delete = newsRepository.save(deleteNews);

        return delete;
    }
}
