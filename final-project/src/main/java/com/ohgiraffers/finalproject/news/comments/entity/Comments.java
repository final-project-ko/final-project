package com.ohgiraffers.finalproject.news.comments.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_comment")
public class Comments {

    @Id
    @Column(name = "comment_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentCode;

    @Column(name = "news_code")
    private Integer newsCode;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String email;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_date")
    private LocalDate date;

    @Column(name = "comment_status")
    private String status;

    @Column(name = "comment_notify")
    private Integer notify;

    public Comments() {
    }

    public Comments(Integer commentCode, Integer newsCode, String userId, String email, String content, LocalDate date, String status, Integer notify) {
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
        return "Comments{" +
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
