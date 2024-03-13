package com.ohgiraffers.finalproject.news.comments.entity;

public class CommentRequest {

    private String newsCode;
    private String userId;
    private String email;
    private String content;

    public CommentRequest() {
    }

    public CommentRequest(String newsCode, String userId, String email, String content) {
        this.newsCode = newsCode;
        this.userId = userId;
        this.email = email;
        this.content = content;
    }

    public String getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(String newsCode) {
        this.newsCode = newsCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}