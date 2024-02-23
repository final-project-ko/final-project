package com.ohgiraffers.finalproject.schedulerApi.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_news")
public class ApiEntity {

    @Id
    @Column(name = "news_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsCode;

    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "title" , length = 500)
    private String title;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "url" , length = 500)
    private String url;
    @Column(name = "urlToImage", length = 500)
    private String urlToImage;

    @Column(name = "date")
    private LocalDate date;

    public ApiEntity() {
    }

    public ApiEntity(int newsCode, String categoryName, String title, String description, String url, String urlToImage, LocalDate date) {
        this.newsCode = newsCode;
        this.categoryName = categoryName;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.date = date;
    }

    @Override
    public String toString() {
        return "ApiEntity{" +
                "newsCode=" + newsCode +
                ", categoryName='" + categoryName + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", date=" + date +
                '}';
    }

    public int getCategoryCode() {
        return newsCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.newsCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public int getNewsCode() {
        return newsCode;
    }

    public void setNewsCode(int newsCode) {
        this.newsCode = newsCode;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
