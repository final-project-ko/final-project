package com.ohgiraffers.finalproject.news.category.contents.repository;

import com.ohgiraffers.finalproject.news.category.contents.entity.KeywordNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordNewsRepository extends JpaRepository<KeywordNews, Integer> {

}