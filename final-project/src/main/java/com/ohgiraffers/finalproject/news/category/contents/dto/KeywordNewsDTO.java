package com.ohgiraffers.finalproject.news.category.contents.dto;

import com.ohgiraffers.finalproject.news.category.contents.entity.KeywordNews;

import java.util.Date;

public class KeywordNewsDTO {

    private Integer keywordNewsCode;
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private String keyword4;
    private String keyword5;
    private String keyword6;
    private String keyword7;
    private String keyword8;
    private String keyword9;
    private String keyword10;
    private String keyword11;
    private String keyword12;
    private String keyword13;
    private String keyword14;
    private String keyword15;
    private Date date;

    public KeywordNewsDTO() {
    }

    public KeywordNewsDTO(KeywordNews keywordNews) {
        this.keywordNewsCode = keywordNews.getKeywordNewsCode();
        this.keyword1 = keywordNews.getKeyword1();
        this.keyword2 = keywordNews.getKeyword2();
        this.keyword3 = keywordNews.getKeyword3();
        this.keyword4 = keywordNews.getKeyword4();
        this.keyword5 = keywordNews.getKeyword5();
        this.keyword6 = keywordNews.getKeyword6();
        this.keyword7 = keywordNews.getKeyword7();
        this.keyword8 = keywordNews.getKeyword8();
        this.keyword9 = keywordNews.getKeyword9();
        this.keyword10 = keywordNews.getKeyword10();
        this.keyword11 = keywordNews.getKeyword11();
        this.keyword12 = keywordNews.getKeyword12();
        this.keyword13 = keywordNews.getKeyword13();
        this.keyword14 = keywordNews.getKeyword14();
        this.keyword15 = keywordNews.getKeyword15();
        this.date = keywordNews.getDate();
    }


    public Integer getKeywordNewsCode() {
        return keywordNewsCode;
    }

    public void setKeywordNewsCode(Integer keywordNewsCode) {
        this.keywordNewsCode = keywordNewsCode;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    public String getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(String keyword4) {
        this.keyword4 = keyword4;
    }

    public String getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5;
    }

    public String getKeyword6() {
        return keyword6;
    }

    public void setKeyword6(String keyword6) {
        this.keyword6 = keyword6;
    }

    public String getKeyword7() {
        return keyword7;
    }

    public void setKeyword7(String keyword7) {
        this.keyword7 = keyword7;
    }

    public String getKeyword8() {
        return keyword8;
    }

    public void setKeyword8(String keyword8) {
        this.keyword8 = keyword8;
    }

    public String getKeyword9() {
        return keyword9;
    }

    public void setKeyword9(String keyword9) {
        this.keyword9 = keyword9;
    }

    public String getKeyword10() {
        return keyword10;
    }

    public void setKeyword10(String keyword10) {
        this.keyword10 = keyword10;
    }

    public String getKeyword11() {
        return keyword11;
    }

    public void setKeyword11(String keyword11) {
        this.keyword11 = keyword11;
    }

    public String getKeyword12() {
        return keyword12;
    }

    public void setKeyword12(String keyword12) {
        this.keyword12 = keyword12;
    }

    public String getKeyword13() {
        return keyword13;
    }

    public void setKeyword13(String keyword13) {
        this.keyword13 = keyword13;
    }

    public String getKeyword14() {
        return keyword14;
    }

    public void setKeyword14(String keyword14) {
        this.keyword14 = keyword14;
    }

    public String getKeyword15() {
        return keyword15;
    }

    public void setKeyword15(String keyword15) {
        this.keyword15 = keyword15;
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
                "keywordNewsCode=" + keywordNewsCode +
                ", keyword1='" + keyword1 + '\'' +
                ", keyword2='" + keyword2 + '\'' +
                ", keyword3='" + keyword3 + '\'' +
                ", keyword4='" + keyword4 + '\'' +
                ", keyword5='" + keyword5 + '\'' +
                ", keyword6='" + keyword6 + '\'' +
                ", keyword7='" + keyword7 + '\'' +
                ", keyword8='" + keyword8 + '\'' +
                ", keyword9='" + keyword9 + '\'' +
                ", keyword10='" + keyword10 + '\'' +
                ", keyword11='" + keyword11 + '\'' +
                ", keyword12='" + keyword12 + '\'' +
                ", keyword13='" + keyword13 + '\'' +
                ", keyword14='" + keyword14 + '\'' +
                ", keyword15='" + keyword15 + '\'' +
                ", date=" + date +
                '}';
    }




}
