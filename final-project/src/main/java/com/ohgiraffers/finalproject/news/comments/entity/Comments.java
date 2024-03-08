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

    @Column(name = "user_email")
    private String email;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_date")
    private LocalDate date;

    public Comments() {
    }

    public Comments(Integer commentCode, Integer newsCode, String email, String content, LocalDate date) {
        this.commentCode = commentCode;
        this.newsCode = newsCode;
        this.email = email;
        this.content = content;
        this.date = date;
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

    @Override
    public String toString() {
        return "Comments{" +
                "commentCode=" + commentCode +
                ", newsCode=" + newsCode +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
