package com.ohgiraffers.finalproject.QNA.controller;


import com.ohgiraffers.finalproject.QNA.dto.QnAArticleDTO;
import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/qna/*")
public class QNAController {

    @Autowired
    private QnaService qnaService;

    @GetMapping("/findAllInquiry")
    public QnAArticleDTO selectAll(){

        List<QnADTO> allInquiry = qnaService.findAllInquiry();

        if(Objects.isNull(allInquiry)){
            return null;
        }
        QnAArticleDTO qnAArticleDTO = new QnAArticleDTO();
        qnAArticleDTO.setArticles(allInquiry);

        return qnAArticleDTO;

    }

    @GetMapping("/findInquiry/{userId}")
    public List<QnADTO> selectInquiry(@PathVariable Long userId){
        List<QnADTO> userInquiry = qnaService.findUserInquiry(userId);

        if(Objects.isNull(userInquiry)){
            return null;
        }

        return userInquiry;
    }

    @PostMapping("/insertInquiry")
    public ResponseEntity insertInquiry(@RequestBody HashMap<String,String> insert){
        // 검증완료
       //  System.out.println(insert.get("id"));

        if (Objects.isNull(insert)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        System.out.println("userId!@#@!#!@!@#!"+insert.get("id"));
        Inquiry insertInquiry = qnaService.insertInquiry(insert);

        if(Objects.isNull(insertInquiry)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(insertInquiry);

    }

    @PostMapping("/deleteInquiry")
    public ResponseEntity deleteInquiry(@RequestBody HashMap<String,String> delete){


        if (Objects.isNull(delete)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        int deleteInq = qnaService.deleteInquiry(delete);

        if(deleteInq == 0){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(deleteInq);


    }

    @PostMapping("/insertReply")
    public ResponseEntity insertReply(@RequestBody HashMap<String,String> insert){


        if (Objects.isNull(insert)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        Inquiry insertReply = qnaService.insertReply(insert);

        if(Objects.isNull(insertReply)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(insertReply);


    }

}
