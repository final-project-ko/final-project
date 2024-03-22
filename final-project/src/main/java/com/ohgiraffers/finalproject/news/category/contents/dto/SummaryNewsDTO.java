package com.ohgiraffers.finalproject.news.category.contents.dto;

import com.ohgiraffers.finalproject.news.category.contents.entity.SummaryNews;

import java.util.Date;

public class SummaryNewsDTO {
    private Integer summaryNewsCode;
    private String summary1;
    private String summary2;
    private String summary3;
    private String summary4;
    private String summary5;
    private Date date;

    public SummaryNewsDTO() {
    }

    public SummaryNewsDTO(SummaryNews summaryNews) {
        this.summaryNewsCode = summaryNews.getSummaryNewsCode();
        this.summary1 = summaryNews.getSummary1();
        this.summary2 = summaryNews.getSummary2();
        this.summary3 = summaryNews.getSummary3();
        this.summary4 = summaryNews.getSummary4();
        this.summary5 = summaryNews.getSummary5();
        this.date = summaryNews.getDate();
    }

    public Integer getSummaryNewsCode() {
        return summaryNewsCode;
    }

    public void setSummaryNewsCode(Integer summaryNewsCode) {
        this.summaryNewsCode = summaryNewsCode;
    }

    public String getSummary1() {
        return summary1;
    }

    public void setSummary1(String summary1) {
        this.summary1 = summary1;
    }

    public String getSummary2() {
        return summary2;
    }

    public void setSummary2(String summary2) {
        this.summary2 = summary2;
    }

    public String getSummary3() {
        return summary3;
    }

    public void setSummary3(String summary3) {
        this.summary3 = summary3;
    }

    public String getSummary4() {
        return summary4;
    }

    public void setSummary4(String summary4) {
        this.summary4 = summary4;
    }

    public String getSummary5() {
        return summary5;
    }

    public void setSummary5(String summary5) {
        this.summary5 = summary5;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "SummaryNewsDTO{" +
                "summaryNewsCode=" + summaryNewsCode +
                ", summary1='" + summary1 + '\'' +
                ", summary2='" + summary2 + '\'' +
                ", summary3='" + summary3 + '\'' +
                ", summary4='" + summary4 + '\'' +
                ", summary5='" + summary5 + '\'' +
                ", date=" + date +
                '}';
    }
}
