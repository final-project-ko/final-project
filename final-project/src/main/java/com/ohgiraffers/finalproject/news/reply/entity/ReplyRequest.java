package com.ohgiraffers.finalproject.news.reply.entity;

public class ReplyRequest {

    private String commentCode;
    private String userId;
    private String email;
    private String content;

    public ReplyRequest() {
    }

    public ReplyRequest(String commentCode, String userId, String email, String content) {
        this.commentCode = commentCode;
        this.userId = userId;
        this.email = email;
        this.content = content;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
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

    @Override
    public String toString() {
        return "ReplyRequest{" +
                "commentCode='" + commentCode + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
