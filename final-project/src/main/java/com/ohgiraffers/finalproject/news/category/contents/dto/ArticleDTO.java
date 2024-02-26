package com.ohgiraffers.finalproject.news.category.contents.dto;

import java.util.List;

public class ArticleDTO {

    private List<NewsDTO> articles;

    public ArticleDTO() {
    }

    public ArticleDTO(List<NewsDTO> articles) {
        this.articles = articles;
    }

    public List<NewsDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsDTO> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "ArticleDTO{" +
                "articles=" + articles +
                '}';
    }
}
