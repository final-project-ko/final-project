package com.ohgiraffers.finalproject.news.category.contents.repository;

import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findAll();

    List<News> findByCategoryAndDate(String category, LocalDate date);
}
