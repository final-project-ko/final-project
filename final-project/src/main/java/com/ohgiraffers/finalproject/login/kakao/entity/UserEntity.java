package com.ohgiraffers.finalproject.login.kakao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
public class UserEntity {



    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_auth")
    private String userAuth;

    @Column(name = "access_token")
    private String accessToken;
    public UserEntity() {
    }

    public UserEntity( String userId, String userName, String userEmail, String userAuth, String accessToken) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAuth = userAuth;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAuth='" + userAuth + '\'' +
                '}';
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(String userAuth) {
        this.userAuth = userAuth;
    }
}
