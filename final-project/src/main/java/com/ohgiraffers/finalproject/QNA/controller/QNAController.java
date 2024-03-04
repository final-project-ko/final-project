package com.ohgiraffers.finalproject.QNA.controller;


import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/api/qna/*")
public class QNAController {

    @Autowired
    private QnaService qnaService;

    @PostMapping("/insertInquiry")
    public ResponseEntity insertInquiry(@RequestBody HashMap<String,String> insert){
        // 검증완료
         System.out.println(insert.get("userCode"));

        if (Objects.isNull(insert)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }


        Inquiry insertInquiry = qnaService.insertInquiry(insert);

        if(Objects.isNull(insertInquiry)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(insertInquiry);

    }
}
