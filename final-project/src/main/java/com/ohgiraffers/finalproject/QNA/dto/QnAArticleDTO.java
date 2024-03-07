package com.ohgiraffers.finalproject.QNA.dto;



import java.util.List;

public class QnAArticleDTO {

    private List<QnADTO> articles;

    public QnAArticleDTO() {
    }

    public QnAArticleDTO(List<QnADTO> articles) {
        this.articles = articles;
    }

    public List<QnADTO> getArticles() {
        return articles;
    }

    public void setArticles(List<QnADTO> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "QnAArticleDTO{" +
                "articles=" + articles +
                '}';
    }
}
