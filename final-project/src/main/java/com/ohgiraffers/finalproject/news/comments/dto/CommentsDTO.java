package com.ohgiraffers.finalproject.news.comments.dto;

import java.time.LocalDate;

public class CommentsDTO {

    private Integer commentCode;
    private Integer newsCode;
    private String email;
    private String content;
    private LocalDate date;

    public CommentsDTO() {
    }

    public CommentsDTO(Integer newsCode, Integer commentCode, String email, LocalDate date, String content) {
        this.newsCode = newsCode;
        this.commentCode = commentCode;
        this.email = email;
        this.date = date;
        this.content = content;
    }

    public Integer getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(Integer newsCode) {
        this.newsCode = newsCode;
    }

    public Integer getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(Integer commentCode) {
        this.commentCode = commentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "newsCode=" + newsCode +
                ", commentCode=" + commentCode +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}