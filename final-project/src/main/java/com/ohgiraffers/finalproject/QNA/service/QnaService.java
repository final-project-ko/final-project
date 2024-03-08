package com.ohgiraffers.finalproject.QNA.service;

import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.repository.InquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QnaService {

    @Autowired
    private InquiryRepository inquiryRepository;
    public List<QnADTO> findUserInquiry(String id) {

        return  inquiryRepository.findByUserId(id)
                .stream()
                .map(inquiry ->{
                    QnADTO qnADTO = new QnADTO();
                    qnADTO.setInquiryCode(inquiry.getInquiryCode());
                    qnADTO.setInquiryTitle(inquiry.getInquiryTitle());
                    qnADTO.setInquiryContent(inquiry.getInquiryContent());
                    qnADTO.setInquiryReply(inquiry.getInquiryReply());
                    qnADTO.setInquiryDate(inquiry.getInquiryDate());
                    qnADTO.setUserId(inquiry.getUserId());
                    qnADTO.setReplyText(inquiry.getReplyText());
                    return qnADTO;
                }).toList();
    }

    public List<QnADTO> findAllInquiry() {

        return  inquiryRepository.findAll()
                .stream()
                .filter(inquiry -> inquiry.getInquiryReply().equals("답변 미작성"))
                .map(inquiry ->{
                        QnADTO qnADTO = new QnADTO();
                        qnADTO.setInquiryCode(inquiry.getInquiryCode());
                        qnADTO.setInquiryTitle(inquiry.getInquiryTitle());
                        qnADTO.setInquiryContent(inquiry.getInquiryContent());
                        qnADTO.setInquiryReply(inquiry.getInquiryReply());
                        qnADTO.setInquiryDate(inquiry.getInquiryDate());
                        qnADTO.setUserId(inquiry.getUserId());
                        return qnADTO;

                }).toList();
    }

    public Inquiry insertInquiry(HashMap<String, String> insert) {

        Inquiry insertInquiry = new Inquiry();
        insertInquiry.setInquiryTitle(insert.get("title"));
        insertInquiry.setInquiryContent(insert.get("text"));
        insertInquiry.setUserId(insert.get("id"));
        insertInquiry.setInquiryDate(LocalDate.now());
        insertInquiry.setInquiryReply("답변 미작성");

        Inquiry inquiry = inquiryRepository.save(insertInquiry);
        return inquiry;

    }

    public int deleteInquiry(HashMap<String,String> delete) {
        try {
            int code = Integer.parseInt(delete.get("code"));
            inquiryRepository.deleteById(code);
            return 1; // 삭제가 성공했을 때 반환할 객체 또는 메시지
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Inquiry insertReply(HashMap<String, String> insert) {


        Inquiry insertReply = new Inquiry();
        insertReply.setInquiryCode(Integer.parseInt(insert.get("code")));
        insertReply.setInquiryTitle(insert.get("title"));
        insertReply.setInquiryContent(insert.get("content"));
        insertReply.setInquiryReply("답변 완료");
        insertReply.setInquiryDate(LocalDate.now());
        insertReply.setUserId(insert.get("userCode"));
        insertReply.setReplyText(insert.get("reply"));

        Inquiry inquirys = inquiryRepository.save(insertReply);
        return inquirys;

    }
}
