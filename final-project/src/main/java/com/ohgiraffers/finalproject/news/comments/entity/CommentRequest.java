package com.ohgiraffers.finalproject.news.comments.entity;

public class CommentRequest {

    private String newsCode;
    private String email;
    private String content;

    public CommentRequest() {
    }

    public CommentRequest(String newsCode, String email, String content) {
        this.newsCode = newsCode;
        this.email = email;
        this.content = content;
    }

    public String getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(String newsCode) {
        this.newsCode = newsCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CommentRequest{" +
                "newsCode='" + newsCode + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}