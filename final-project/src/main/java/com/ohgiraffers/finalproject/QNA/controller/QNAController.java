package com.ohgiraffers.finalproject.QNA.controller;


import com.ohgiraffers.finalproject.QNA.dto.QnAArticleDTO;
import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Tag(name = "Q&A", description = "Q&A api")
@RestController
@RequestMapping("/api/qna/*")
@CrossOrigin(origins = "*")
public class QNAController {

    @Autowired
    private QnaService qnaService;

    @Operation(summary = "전체 Q&A 조회", description = "전체 Q&A 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
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
    @Operation(summary = " Q&A 검색", description = "특정 Q&A 검색 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/findInquiry/{userId}")
    public List<QnADTO> selectInquiry(@PathVariable String userId){
        List<QnADTO> userInquiry = qnaService.findUserInquiry(userId);

        if(Objects.isNull(userInquiry)){
            return null;
        }

        return userInquiry;
    }

    @Operation(summary = " Q&A 등록", description = "유저별 Q&A 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
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

    @Operation(summary = " Q&A 삭제", description = "유저별 Q&A 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
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

    @Operation(summary = "어드민 Q&A 답글 등록", description = "유저별 Q&A 어드민 답글 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
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

    @Operation(summary = "어드민 Q&A 답글 삭제", description = "유저별 Q&A 어드민 답글 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/deleteReply")
    public ResponseEntity deleteReply(@RequestBody HashMap<String,String> delete){


        if (Objects.isNull(delete)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        int deleteInq = qnaService.deleteReply(delete);

        if(deleteInq == 0){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(deleteInq);


    }

}
