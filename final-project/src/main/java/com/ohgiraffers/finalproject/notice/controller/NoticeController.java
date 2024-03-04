package com.ohgiraffers.finalproject.notice.controller;

import com.ohgiraffers.finalproject.notice.dto.NoticeDTO;
import com.ohgiraffers.finalproject.notice.entity.Notice;
import com.ohgiraffers.finalproject.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/notice/*")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/allNotice")
    public  List<NoticeDTO> allNotice(){

        List<NoticeDTO> result = noticeService.findAllNotice();

        return result;
    }

    @GetMapping("/searchNotice/{inputText}")
    public List<NoticeDTO> searchNotice(@PathVariable String inputText){

        List<NoticeDTO> result = noticeService.findInputNotice(inputText);

        return result;
    }

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
