package com.ohgiraffers.finalproject.news.category.contents.entity;

import com.ohgiraffers.finalproject.news.category.contents.dto.KeywordNewsDTO;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_keyword_news")
public class KeywordNews {

    @Id
    @Column(name = "keyword_news_code")
    @GeneratedValue
    private Integer keywordNewsCode;
    @Column(name = "keyword_1")
    private String keyword1;
    @Column(name = "keyword_2")
    private String keyword2;
    @Column(name = "keyword_3")
    private String keyword3;
    @Column(name = "keyword_4")
    private String keyword4;
    @Column(name = "keyword_5")
    private String keyword5;
    @Column(name = "keyword_6")
    private String keyword6;
    @Column(name = "keyword_7")
    private String keyword7;
    @Column(name = "keyword_8")
    private String keyword8;
    @Column(name = "keyword_9")
    private String keyword9;
    @Column(name = "keyword_10")
    private String keyword10;
    @Column(name = "keyword_11")
    private String keyword11;
    @Column(name = "keyword_12")
    private String keyword12;
    @Column(name = "keyword_13")
    private String keyword13;
    @Column(name = "keyword_14")
    private String keyword14;
    @Column(name = "keyword_15")
    private String keyword15;
    @Column(name = "date")
    private Date date;

    public KeywordNews() {
    }

    public KeywordNews(KeywordNewsDTO keywordNewsDTO) {
        this.keywordNewsCode = keywordNewsDTO.getKeywordNewsCode();
        this.keyword1 = keywordNewsDTO.getKeyword1();
        this.keyword2 = keywordNewsDTO.getKeyword2();
        this.keyword3 = keywordNewsDTO.getKeyword3();
        this.keyword4 = keywordNewsDTO.getKeyword4();
        this.keyword5 = keywordNewsDTO.getKeyword5();
        this.keyword6 = keywordNewsDTO.getKeyword6();
        this.keyword7 = keywordNewsDTO.getKeyword7();
        this.keyword8 = keywordNewsDTO.getKeyword8();
        this.keyword9 = keywordNewsDTO.getKeyword9();
        this.keyword10 = keywordNewsDTO.getKeyword10();
        this.keyword11 = keywordNewsDTO.getKeyword11();
        this.keyword12 = keywordNewsDTO.getKeyword12();
        this.keyword13 = keywordNewsDTO.getKeyword13();
        this.keyword14 = keywordNewsDTO.getKeyword14();
        this.keyword15 = keywordNewsDTO.getKeyword15();
        this.date = keywordNewsDTO.getDate();
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
        return "KeywordNews{" +
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
