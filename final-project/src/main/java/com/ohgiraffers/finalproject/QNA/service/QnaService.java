package com.ohgiraffers.finalproject.QNA.service;

import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.repository.InquiryRepository;
import com.ohgiraffers.finalproject.notice.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;

@Service
public class QnaService {

    @Autowired
    private InquiryRepository inquiryRepository;
    public Inquiry insertInquiry(HashMap<String, String> insert) {

        Inquiry insertInquiry = new Inquiry();
        insertInquiry.setInquiryTitle(insert.get("title"));
        insertInquiry.setInquiryContent(insert.get("text"));
        insertInquiry.setUserCode(Integer.parseInt(insert.get("userCode")));
        insertInquiry.setInquiryDate(LocalDate.now());
        insertInquiry.setInquiryReply("답글 미작성");

        Inquiry inquiry = inquiryRepository.save(insertInquiry);
        return inquiry;

    }
}
