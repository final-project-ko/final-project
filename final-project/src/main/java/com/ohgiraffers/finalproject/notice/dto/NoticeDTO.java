package com.ohgiraffers.finalproject.notice.dto;

import java.time.LocalDate;
import java.util.Date;

public class NoticeDTO {

    private int notice_num;
    private String notice_title;
    private String notice_content;
    private LocalDate notice_date;

    public NoticeDTO() {
    }

    public NoticeDTO(int notice_num, String notice_title, String notice_content, LocalDate notice_date) {
        this.notice_num = notice_num;
        this.notice_title = notice_title;
        this.notice_content = notice_content;
        this.notice_date = notice_date;
    }

    public int getNotice_num() {
        return notice_num;
    }

    public void setNotice_num(int notice_num) {
        this.notice_num = notice_num;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_content() {
        return notice_content;
    }

    public void setNotice_content(String notice_content) {
        this.notice_content = notice_content;
    }

    public LocalDate getNotice_date() {
        return notice_date;
    }

    public void setNotice_date(LocalDate notice_date) {
        this.notice_date = notice_date;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "notice_code=" + notice_num +
                ", notice_title='" + notice_title + '\'' +
                ", notice_content='" + notice_content + '\'' +
                ", notice_date='" + notice_date + '\'' +
                '}';
    }
}
