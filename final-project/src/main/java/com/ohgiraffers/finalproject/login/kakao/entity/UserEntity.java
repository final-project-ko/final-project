package com.ohgiraffers.finalproject.login.kakao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user")
public class UserEntity {

    @Id
    @Column(name = "user_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userCode;

    @Column(name = "user_id")
    private long userId;


    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_auth")
    private String userAuth;

    public UserEntity() {
    }

    public UserEntity(long userId, String userName, String userEmail, String userAuth) {
        this.userCode = userCode;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userAuth = userAuth;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userCode=" + userCode +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAuth='" + userAuth + '\'' +
                '}';
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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
