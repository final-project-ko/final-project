package com.ohgiraffers.finalproject.notice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_notice")
public class Notice {

    @Id
    @Column(name = "notice_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column(name = "notice_title")
    private String title;

    @Column(name = "notice_content", length = 3000)
    private String content;

    @Column(name = "notice_date")
    private LocalDate date;

    public Notice() {
    }

    public Notice(int num, String title, String content, LocalDate date) {
        this.num = num;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Notice{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
