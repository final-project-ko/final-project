package com.ohgiraffers.finalproject.news.category.contents.repository;

import com.ohgiraffers.finalproject.news.category.contents.entity.SummaryNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SummaryNewsRepository extends JpaRepository<SummaryNews, Integer> {
    // 추가적인 메서드가 필요한 경우 여기에 작성할 수 있습니다.


    SummaryNews findBySummaryNewsCode(int i);
}
