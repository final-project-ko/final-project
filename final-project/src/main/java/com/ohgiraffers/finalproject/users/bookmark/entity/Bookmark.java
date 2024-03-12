package com.ohgiraffers.finalproject.users.bookmark.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_bookmark")
public class Bookmark {

    @Id
    @Column(name = "bookmark_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookmarkCode;

    @Column(name = "news_code")
    private Integer newsCode;

    @Column(name = "user_email")
    private String email;

    public Bookmark() {
    }

    public Bookmark(Integer bookmarkCode, Integer newsCode, String email) {
        this.bookmarkCode = bookmarkCode;
        this.newsCode = newsCode;
        this.email = email;
    }

    public Integer getBookmarkCode() {
        return bookmarkCode;
    }

    public void setBookmarkCode(Integer bookmarkCode) {
        this.bookmarkCode = bookmarkCode;
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

    @Override
    public String toString() {
        return "Bookmark{" +
                "bookmarkCode=" + bookmarkCode +
                ", newsCode=" + newsCode +
                ", email='" + email + '\'' +
                '}';
    }
}
