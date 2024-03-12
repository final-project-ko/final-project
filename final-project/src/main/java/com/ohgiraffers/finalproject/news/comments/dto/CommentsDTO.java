package com.ohgiraffers.finalproject.news.comments.dto;

import java.time.LocalDate;

public class CommentsDTO {

    private Integer commentCode;
    private Integer newsCode;
    private String userId;
    private String email;
    private String content;
    private LocalDate date;
    private String status;
    private Integer notify;

    public CommentsDTO() {
    }

    public CommentsDTO(Integer commentCode, Integer newsCode, String userId, String email, String content, LocalDate date, String status, Integer notify) {
        this.commentCode = commentCode;
        this.newsCode = newsCode;
        this.userId = userId;
        this.email = email;
        this.content = content;
        this.date = date;
        this.status = status;
        this.notify = notify;
    }

    public Integer getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(Integer commentCode) {
        this.commentCode = commentCode;
    }

    public Integer getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(Integer newsCode) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNotify() {
        return notify;
    }

    public void setNotify(Integer notify) {
        this.notify = notify;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" +
                "commentCode=" + commentCode +
                ", newsCode=" + newsCode +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", notify=" + notify +
                '}';
    }
}