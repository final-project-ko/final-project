package com.ohgiraffers.finalproject.QNA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_inquiry")
public class Inquiry {

    @Id
    @Column(name = "inquiry_code")
    private int inquiryCode;

    @Column(name = "inquiry_title")
    private String inquiryTitle;

    @Column(name = "inquiry_content")
    private String inquiryContent;

    @Column(name = "inquiry_date")
    private LocalDate inquiryDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "inquiry_reply")
    private String inquiryReply;

    @Column(name = "reply_text")
    private String replyText;


    public Inquiry() {
    }

    public Inquiry(int inquiryCode, String inquiryTitle, String inquiryContent, LocalDate inquiryDate, String userId, String inquiryReply, String replyText) {
        this.inquiryCode = inquiryCode;
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
        this.inquiryDate = inquiryDate;
        this.userId = userId;
        this.inquiryReply = inquiryReply;
        this.replyText = replyText;
    }

    public int getInquiryCode() {
        return inquiryCode;
    }

    public void setInquiryCode(int inquiryCode) {
        this.inquiryCode = inquiryCode;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryContent() {
        return inquiryContent;
    }

    public void setInquiryContent(String inquiryContent) {
        this.inquiryContent = inquiryContent;
    }

    public LocalDate getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(LocalDate inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInquiryReply() {
        return inquiryReply;
    }

    public void setInquiryReply(String inquiryReply) {
        this.inquiryReply = inquiryReply;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    @Override
    public String toString() {
        return "Inquiry{" +
                "inquiryCode=" + inquiryCode +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryContent='" + inquiryContent + '\'' +
                ", inquiryDate=" + inquiryDate +
                ", userCode=" + userId +
                ", inquiryReply='" + inquiryReply + '\'' +
                ", replyText='" + replyText + '\'' +
                '}';
    }
}
