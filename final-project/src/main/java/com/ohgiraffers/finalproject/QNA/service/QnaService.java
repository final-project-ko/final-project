package com.ohgiraffers.finalproject.QNA.service;

import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

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

    public List<QnADTO> findUserInquiry(int userCode) {

        return  inquiryRepository.findByUserCode(userCode)
                .stream()
                .map(inquiry ->{
                    QnADTO qnADTO = new QnADTO();
                    qnADTO.setInquiryCode(inquiry.getInquiryCode());
                    qnADTO.setInquiryTitle(inquiry.getInquiryTitle());
                    qnADTO.setInquiryContent(inquiry.getInquiryContent());
                    qnADTO.setInquiryReply(inquiry.getInquiryReply());
                    qnADTO.setInquiryDate(inquiry.getInquiryDate());
                    qnADTO.setUserCode(inquiry.getUserCode());
                    return qnADTO;
                }).toList();
    }
}
