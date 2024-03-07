package com.ohgiraffers.finalproject.QNA.repository;


import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

    List<Inquiry> findByUserId(long userId);
}
