package com.ohgiraffers.finalproject.news.category.contents.entity;

import com.ohgiraffers.finalproject.news.category.contents.dto.SummaryNewsDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_summary_news")
public class SummaryNews {

    @Id
    @Column(name = "summary_news_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer summaryNewsCode;

    @Column(name = "summary_news_1")
    private String summaryNews1;

    @Column(name = "summary_news_2")
    private String summaryNews2;

    @Column(name = "summary_news_3")
    private String summaryNews3;

    @Column(name = "summary_news_4")
    private String summaryNews4;

    @Column(name = "summary_news_5")
    private String summaryNews5;

    @Column(name = "date")
    private Date date;

    public SummaryNews() {
    }

    public SummaryNews(Integer summaryNewsCode, String summaryNews1, String summaryNews2, String summaryNews3, String summaryNews4, String summaryNews5, Date date) {
        this.summaryNewsCode = summaryNewsCode;
        this.summaryNews1 = summaryNews1;
        this.summaryNews2 = summaryNews2;
        this.summaryNews3 = summaryNews3;
        this.summaryNews4 = summaryNews4;
        this.summaryNews5 = summaryNews5;
        this.date = date;
    }

    public Integer getSummaryNewsCode() {
        return summaryNewsCode;
    }

    public void setSummaryNewsCode(Integer summaryNewsCode) {
        this.summaryNewsCode = summaryNewsCode;
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

    @Override
    public String toString() {
        return "SummaryNews{" +
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
