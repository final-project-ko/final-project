package com.ohgiraffers.finalproject.news.reply.dto;

import java.time.LocalDate;

public class ReplyDTO {

    private Integer commentCode;
    private Integer replyCode;
    private Integer userId;
    private String email;
    private String content;
    private LocalDate date;
    private String status;
    private Integer notify;

    public ReplyDTO() {
    }

    public ReplyDTO(Integer commentCode, Integer replyCode, Integer userId, String email, String content, LocalDate date, String status, Integer notify) {
        this.commentCode = commentCode;
        this.replyCode = replyCode;
        this.userId = userId;
        this.email = email;
        this.content = content;
        this.date = date;
        this.status = status;
        this.notify = notify;
    }

    public Integer getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(Integer commentCode) {
        this.commentCode = commentCode;
    }

    public Integer getReplyCode() {
        return replyCode;
    }

    public void setReplyCode(Integer replyCode) {
        this.replyCode = replyCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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
        return "ReplyDTO{" +
                "commentCode=" + commentCode +
                ", replyCode=" + replyCode +
                ", userId=" + userId +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", notify=" + notify +
                '}';
    }
}
