package com.ohgiraffers.finalproject.QNA.repository;

import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {

}
