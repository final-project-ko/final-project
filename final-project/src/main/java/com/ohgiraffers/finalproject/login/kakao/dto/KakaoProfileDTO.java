package com.ohgiraffers.finalproject.login.kakao.dto;

public class KakaoProfileDTO {

    private String id;
    private String name;
    private String email;

    private String userAuth;

    private String accessToken;

    public KakaoProfileDTO() {
    }

    public KakaoProfileDTO(String id, String name, String email, String userAuth, String accessToken) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userAuth = userAuth;
        this.accessToken = accessToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "KakaoProfileDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
