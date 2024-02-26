package com.ohgiraffers.finalproject.news.category.contents.controller;

import com.ohgiraffers.finalproject.news.category.contents.dto.ArticleDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// DB에서 조회하는 뉴스
@RestController
public class ContentsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/allNews")
    public List<NewsDTO> selectNews() {

        List<NewsDTO> result = newsService.findAllNews();
        System.out.println(result.toString());

        return result;

    }

    @GetMapping("/categoryNews/{category}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ArticleDTO categoryNews(@PathVariable String category) {
        LocalDate today = LocalDate.now();

        List<NewsDTO> result = newsService.categoryNews(category, today);

        List<NewsDTO> newsList = new ArrayList<>();
        int count = 0;

        for (NewsDTO news : result) {
            if (count >= 10) {
                break;
            }
            newsList.add(news);
            count++;
        }
        System.out.println(newsList);

        ArticleDTO articles = new ArticleDTO();
        articles.setArticles(newsList);

        return articles;
    }
}
