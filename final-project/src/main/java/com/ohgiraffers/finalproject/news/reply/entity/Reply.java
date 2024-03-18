package com.ohgiraffers.finalproject.news.reply.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_reply")
public class Reply {

    @Id
    @Column(name = "reply_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer replyCode;

    @Column(name = "comment_code")
    private Integer commentCode;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_email")
    private String email;

    @Column(name = "reply_content")
    private String content;

    @Column(name = "reply_date")
    private LocalDate date;

    @Column(name = "reply_status")
    private String status;

    @Column(name = "reply_notify")
    private Integer notify;

    public Reply() {
    }

    public Reply(Integer replyCode, Integer commentCode, String userId, String email, String content, LocalDate date, String status, Integer notify) {
        this.replyCode = replyCode;
        this.commentCode = commentCode;
        this.userId = userId;
        this.email = email;
        this.content = content;
        this.date = date;
        this.status = status;
        this.notify = notify;
    }

    public Integer getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(Integer replyCode) {
        this.replyCode = replyCode;
    }

    public Integer getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(Integer commentCode) {
        this.commentCode = commentCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getNotify() {
        return notify;
    }

    public void setNotify(Integer notify) {
        this.notify = notify;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyCode=" + replyCode +
                ", commentCode=" + commentCode +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", notify=" + notify +
                '}';
    }
}
