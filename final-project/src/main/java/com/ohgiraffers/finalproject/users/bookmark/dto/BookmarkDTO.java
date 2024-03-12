package com.ohgiraffers.finalproject.users.bookmark.dto;

public class BookmarkDTO {

    private Integer bookmarkCode;
    private Integer newsCode;
    private String email;

    public BookmarkDTO() {
    }

    public BookmarkDTO(Integer bookmarkCode, Integer newsCode, String email) {
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
        return "BookmarkDTO{" +
                "bookmarkCode=" + bookmarkCode +
                ", newsCode=" + newsCode +
                ", email='" + email + '\'' +
                '}';
    }
}


