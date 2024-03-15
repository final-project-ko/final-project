package com.ohgiraffers.finalproject.news.category.contents.dto;

import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import jakarta.persistence.Column;

import java.time.LocalDate;

public class NewsDTO {

    private Integer code;  // 2024-03-15 entity와 데이터 유형 맞춤
    private String title;
    private String category;
    private String description;
    private String url;
    private String image;
    private LocalDate date;
    private String aidescription; // 2024-03-12 ai컬럼 추가
    private String transdescription; // 2024-03-15 ai 한국어 번역 컬럼 추가


    public NewsDTO() {
    }

    // 2024-03-15 - 받는 매개변수를 News엔터티에 기반하도록 수정
    public NewsDTO(News news) {
        this.code = news.getCode();
        this.title = news.getTitle();
        this.category = news.getCategory();
        this.description = news.getDescription();
        this.url = news.getUrl();
        this.image = news.getImage();
        this.date = news.getDate();
        this.aidescription = news.getAidescription();
        this.transdescription = news.getTransdescription();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAidescription() {
        return aidescription;
    }

    public void setAidescription(String aidescription) {
        this.aidescription = aidescription;
    }

    public String getTransdescription() {
        return transdescription;
    }

    public void setTransdescription(String transdescription) {
        this.transdescription = transdescription;
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", image='" + image + '\'' +
                ", date=" + date +
                ", aidescription='" + aidescription + '\'' +
                ", transdescription='" + transdescription + '\'' +
                '}';
    }
}
