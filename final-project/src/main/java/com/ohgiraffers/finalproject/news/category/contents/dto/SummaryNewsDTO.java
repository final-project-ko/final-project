package com.ohgiraffers.finalproject.news.category.contents.dto;

import com.ohgiraffers.finalproject.news.category.contents.entity.SummaryNews;

import java.util.Date;

public class SummaryNewsDTO {
    private Integer summaryNewsCode;
    private String summaryNews1;
    private String summaryNews2;
    private String summaryNews3;
    private String summaryNews4;
    private String summaryNews5;
    private Date date;

    public SummaryNewsDTO() {
    }

    public SummaryNewsDTO(SummaryNews summaryNews) {
        this.summaryNewsCode = summaryNews.getSummaryNewsCode();
        this.summaryNews1 = summaryNews.getSummaryNews1();
        this.summaryNews2 = summaryNews.getSummaryNews2();
        this.summaryNews3 = summaryNews.getSummaryNews3();
        this.summaryNews4 = summaryNews.getSummaryNews4();
        this.summaryNews5 = summaryNews.getSummaryNews5();
        this.date = summaryNews.getDate();
    }

    public String getSummaryNews1() {
        return summaryNews1;
    }

    public void setSummaryNews1(String summaryNews1) {
        this.summaryNews1 = summaryNews1;
    }

    public String getSummaryNews2() {
        return summaryNews2;
    }

    public void setSummaryNews2(String summaryNews2) {
        this.summaryNews2 = summaryNews2;
    }

    public String getSummaryNews3() {
        return summaryNews3;
    }

    public void setSummaryNews3(String summaryNews3) {
        this.summaryNews3 = summaryNews3;
    }

    public String getSummaryNews4() {
        return summaryNews4;
    }

    public void setSummaryNews4(String summaryNews4) {
        this.summaryNews4 = summaryNews4;
    }

    public String getSummaryNews5() {
        return summaryNews5;
    }

    public void setSummaryNews5(String summaryNews5) {
        this.summaryNews5 = summaryNews5;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSummaryNewsCode() {
        return summaryNewsCode;
    }

    public void setSummaryNewsCode(Integer summaryNewsCode) {
        this.summaryNewsCode = summaryNewsCode;
    }

    @Override
    public String toString() {
        return "SummaryNewsDTO{" +
                "summaryNewsCode=" + summaryNewsCode +
                ", summaryNews1='" + summaryNews1 + '\'' +
                ", summaryNews2='" + summaryNews2 + '\'' +
                ", summaryNews3='" + summaryNews3 + '\'' +
                ", summaryNews4='" + summaryNews4 + '\'' +
                ", summaryNews5='" + summaryNews5 + '\'' +
                ", date=" + date +
                '}';
    }
}
