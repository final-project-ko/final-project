package com.ohgiraffers.finalproject.notice.controller;

import com.ohgiraffers.finalproject.notice.dto.NoticeDTO;
import com.ohgiraffers.finalproject.notice.entity.Notice;
import com.ohgiraffers.finalproject.notice.service.NoticeService;
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

@Tag(name = "공지사항", description = "공지사항 api")
@RestController
@RequestMapping("/api/notice/*")
@CrossOrigin(origins = "*")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Operation(summary = "전체 공지 사항 조회", description = "전체 공지 사항 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/allNotice")
    public  List<NoticeDTO> allNotice(){

        List<NoticeDTO> result = noticeService.findAllNotice();

        return result;
    }

    @Operation(summary = "공지 사항 검색", description = "공지 사항 검색 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/searchNotice/{inputText}")
    public List<NoticeDTO> searchNotice(@PathVariable String inputText){

        List<NoticeDTO> result = noticeService.findInputNotice(inputText);

        return result;
    }

    @Operation(summary = "공지 사항 입력", description = "어드민 공지 사항 입력 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/insertNotice")
    public ResponseEntity insertNotice(@RequestBody HashMap<String,String> notice){

        if (Objects.isNull(notice)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

       //  System.out.println(notice.get("values"));  불러오기 검증완료
        Notice insertNotice = noticeService.insertNotice(notice);

        if(Objects.isNull(insertNotice)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(insertNotice);
    }

    @Operation(summary = "공지 사항 수정", description = "어드민 공지 사항 수정 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("modifyNotice")
    public ResponseEntity modifyNotice(@RequestBody HashMap<String,String> notice){

        if (Objects.isNull(notice)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }
        Notice modifyNotice = noticeService.modifyNotice(notice);

        if(Objects.isNull(modifyNotice)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(modifyNotice);

    }


    @Operation(summary = "공지 사항 삭제", description = "어드민 공지 사항 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("deleteNotice")
    public ResponseEntity deleteNotice(@RequestBody HashMap<String,String> notice){

        if (Objects.isNull(notice)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }
        Notice deleteNotice = noticeService.deleteNotice(notice);

        if(Objects.isNull(deleteNotice)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(deleteNotice);

    }



}
