package com.ohgiraffers.finalproject.notice.repository;

import com.ohgiraffers.finalproject.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice,Integer> {

    List<Notice> findAll();
}
