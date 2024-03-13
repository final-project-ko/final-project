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

    @Column(name = "news_title")
    private String title;

    @Column(name = "news_description")
    private String description;
    @Column(name = "news_url")
    private String url;

    @Column(name = "news_image")
    private String image;

    @Column(name = "user_id")
    private String userId;

    public Bookmark() {
    }

    public Bookmark(Integer bookmarkCode, Integer newsCode, String title, String description, String url, String image, String userId) {
        this.bookmarkCode = bookmarkCode;
        this.newsCode = newsCode;
        this.title = title;
        this.description = description;
        this.url = url;
        this.image = image;
        this.userId = userId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "bookmarkCode=" + bookmarkCode +
                ", newsCode=" + newsCode +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
