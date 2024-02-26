package com.ohgiraffers.finalproject.news.category.contents.dto;

import java.time.LocalDate;

public class NewsDTO {

    private int code;
    private String title;
    private String category;
    private String description;
    private String url;
    private String image;
    private LocalDate date;

    public NewsDTO() {
    }

    public NewsDTO(int code, String title, String category, String description, String url, String image, LocalDate date) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.description = description;
        this.url = url;
        this.image = image;
        this.date = date;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
                '}';
    }
}
