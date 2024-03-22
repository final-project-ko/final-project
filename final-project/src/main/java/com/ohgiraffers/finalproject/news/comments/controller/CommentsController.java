package com.ohgiraffers.finalproject.news.comments.controller;

import com.ohgiraffers.finalproject.news.comments.dto.CommentsDTO;
import com.ohgiraffers.finalproject.news.comments.entity.CommentRequest;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.service.CommentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Tag(name = "댓글", description = "해당 뉴스의 댓글 정보 api")
@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Operation(summary = "뉴스 댓글 등록", description = "뉴스 댓글 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/regist")
//    @CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
    public ResponseEntity registComment(@RequestBody HashMap<String,String> comment) {
/*        System.out.println(comment);*/
        if (Objects.isNull(comment.get("newsCode")) || comment.get("newsCode").isEmpty()) {
            return ResponseEntity.status(405).body("newsCode 정보가 없습니다.");
        } else if (Objects.isNull(comment.get("email")) || comment.get("email").isEmpty()) {
            return ResponseEntity.status(401).body("email 정보가 없습니다.");
        } else if (Objects.isNull(comment.get("content")) || comment.get("content").isEmpty()) {
            return ResponseEntity.status(402).body("내용이 없습니다.");
        }

        Comments registComment = commentsService.registComment(comment);

        if (Objects.isNull(registComment)) {
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(registComment);
    }

    @Operation(summary = "뉴스 댓글 조회", description = "뉴스 댓글 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/find/{newsCode}")
    public List<CommentsDTO> findComments(@PathVariable int newsCode){
 /*       System.out.println(newsCode);*/

        List<CommentsDTO> commentList = commentsService.findComments(newsCode);
/*        System.out.println(commentList);*/

        if(Objects.isNull(commentList)){
            return null;
        }

        return commentList;
    }

    @Operation(summary = "오늘 댓글 조회", description = "오늘 달린 뉴스 댓글 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/userComments")
    public List<CommentsDTO> userComments(){
        LocalDate today = LocalDate.now();

        List<CommentsDTO> commentsList = commentsService.findTodayComments(today);
        if(Objects.isNull(commentsList)){
            return null;
        }
        return commentsList;
    }

    @Operation(summary = "전체 댓글 조회", description = "전체 뉴스 댓글 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/allComments")
    public List<CommentsDTO> allComments() {


        List<CommentsDTO> commentsList = commentsService.findAllComments();
        if (Objects.isNull(commentsList)) {
            return null;
        }
        commentsList = commentsList.stream().sorted(Comparator.comparing(CommentsDTO::getDate).reversed()).collect(Collectors.toList());
                                                    // DTO안에 date를 기준으로 내림차순 정렬

        return commentsList;
    }

    @Operation(summary = "유저별 댓글 조회", description = "유저별 댓글 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/findUser/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
    public List<CommentsDTO> findComments(@PathVariable String id){
        if (Objects.isNull(id)) {
            return null;
        }
        /*System.out.println(id);*/

        List<CommentsDTO> commentsList = commentsService.findByUserId(id);

        if (commentsList.isEmpty()){
            return null;
        }


        return commentsList;
    }

    @Operation(summary = "신고 댓글 삭제", description = "신고 댓글 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/deleteComments")
    public ResponseEntity deleteComments(@RequestBody HashMap<String,String> comments){
        String code = comments.get("code");
        /*System.out.println(code);*/

        Comments result = commentsService.deleteComments(code);

        if (result == null) {
           return ResponseEntity.status(404).body("오류 발생");
        }

        return ResponseEntity.ok(result);

    }


    @Operation(summary = "댓글 삭제", description = "댓글 작성자의 댓글 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/modifyComment/{commentCode}")
    public ResponseEntity modifyCommentStatus(@PathVariable Integer commentCode) {

        // 요청 값 확인
//        System.out.println("commentCode : " + commentCode);

        Comments updateComment = commentsService.modifyCommentStatus(commentCode);

        // 수정된 댓글 확인
//        System.out.println(updateComment);

        return ResponseEntity.ok(updateComment);
    }

    @Operation(summary = "댓글 신고", description = "댓글 신고 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/notifyComment/{commentCode}")
    public ResponseEntity modifyCommentNotify(@PathVariable int commentCode) {

        Comments updateComment = commentsService.modifyCommentNotify(commentCode);

        return ResponseEntity.ok(updateComment);
    }


    @Operation(summary = "어드민 댓글 신고 처리", description = "어드민 댓글 신고 처리 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/adminNotify")
    public List<CommentsDTO> adminNotify(){

        List<CommentsDTO> result = commentsService.findAdminFind();
        if (result.isEmpty()){
            return result;
        }

        return result;

    }


}
