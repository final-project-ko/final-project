package com.ohgiraffers.finalproject.news.reply.controller;

import com.ohgiraffers.finalproject.news.reply.dto.ReplyDTO;
import com.ohgiraffers.finalproject.news.reply.dto.ReplyListDTO;
import com.ohgiraffers.finalproject.news.reply.entity.Reply;
import com.ohgiraffers.finalproject.news.reply.entity.ReplyRequest;
import com.ohgiraffers.finalproject.news.reply.service.ReplyService;
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

@Tag(name = "답글", description = "해당 댓글의 답글 정보 api")
@RestController
@RequestMapping("/api/reply")
@CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Operation(summary = "댓글 답글 등록", description = "댓글 답글 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/regist")
    public ResponseEntity registReply(@RequestBody HashMap<String,String> reply) {
        System.out.println(reply);
        if (Objects.isNull(reply.get("commentCode"))) {
            return ResponseEntity.status(404).body("댓글 코드가 없습니다.");
        } else if (Objects.isNull(reply.get("userId")) || reply.get("userId").isEmpty()) {
            return ResponseEntity.status(401).body("유저 코드가 없습니다.");
        } else if (Objects.isNull(reply.get("email"))) {
            return ResponseEntity.status(403).body("email 정보가 없습니다.");
        } else if (Objects.isNull(reply.get("content")) || reply.get("content").equals("")) {
            return ResponseEntity.status(402).body("내용이 없습니다.");
        }

        Reply registReply = replyService.registReply(reply);

        if (Objects.isNull(registReply)) {
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }
        System.out.println(registReply);

        return ResponseEntity.ok(registReply);
    }

    @Operation(summary = "답글 조회", description = "답글 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    @GetMapping("/find/{commentCode}")
    public ResponseEntity findReply(@PathVariable int commentCode) {

        if (Objects.isNull(commentCode)) {
            return ResponseEntity.status(500).body("서버오류. commnetCode 정보가 없습니다.");
        }

        List<ReplyDTO> replyList = replyService.findReply(commentCode);

        if (Objects.isNull(replyList)) {
            return ResponseEntity.status(500).body("서버오류. 답글 조회 오류");
        }

        ReplyListDTO replys = new ReplyListDTO();
        replys.setReplys(replyList);

        return ResponseEntity.ok(replys);
    }
}
