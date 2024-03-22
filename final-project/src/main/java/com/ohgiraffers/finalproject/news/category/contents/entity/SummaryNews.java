package com.ohgiraffers.finalproject.news.category.contents.entity;

import com.ohgiraffers.finalproject.news.category.contents.dto.SummaryNewsDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_summary_news")
public class SummaryNews {

    @Id
    @Column(name = "summary_news_code")
    private Integer summaryNewsCode;

    @Column(name = "summary_news_1")
    private String summary1;
    @Column(name = "summary_news_2")
    private String summary2;
    @Column(name = "summary_news_3")
    private String summary3;
    @Column(name = "summary_news_4")
    private String summary4;
    @Column(name = "summary_news_5")
    private String summary5;

    @Column(name = "date")
    private Date date;

    public SummaryNews() {
    }

    public SummaryNews(Integer summaryNewsCode, String summary1, String summary2, String summary3, String summary4, String summary5, Date date) {
        this.summaryNewsCode = summaryNewsCode;
        this.summary1 = summary1;
        this.summary2 = summary2;
        this.summary3 = summary3;
        this.summary4 = summary4;
        this.summary5 = summary5;
        this.date = date;
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
        return "SummaryNews{" +
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
