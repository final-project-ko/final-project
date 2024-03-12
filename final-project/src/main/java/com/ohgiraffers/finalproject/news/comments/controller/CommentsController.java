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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Tag(name = "댓글", description = "해당 뉴스의 댓글 정보 api")
@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
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
    public ResponseEntity registComment(@RequestBody CommentRequest comment) {
        System.out.println(comment);
        if (Objects.isNull(comment.getNewsCode()) || comment.getNewsCode().isEmpty()) {
            return ResponseEntity.status(405).body("newsCode 정보가 없습니다.");
        } else if (Objects.isNull(comment.getEmail()) || comment.getEmail().isEmpty()) {
            return ResponseEntity.status(401).body("email 정보가 없습니다.");
        } else if (Objects.isNull(comment.getContent()) || comment.getContent().isEmpty()) {
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
        System.out.println(newsCode);

        List<CommentsDTO> commentList = commentsService.findComments(newsCode);
        System.out.println(commentList);

        if(Objects.isNull(commentList)){
            return null;
        }

        return commentList;
    }

    @GetMapping("/userComments")
    public List<CommentsDTO> userComments(){
        LocalDate today = LocalDate.now();

        List<CommentsDTO> commentsList = commentsService.findTodayComments(today);
        if(Objects.isNull(commentsList)){
            return null;
        }
        return commentsList;
    }

    @GetMapping("/allComments")
    public List<CommentsDTO> allComments() {


        List<CommentsDTO> commentsList = commentsService.findAllComments();
        if (Objects.isNull(commentsList)) {
            return null;
        }
        return commentsList;
    }


    @GetMapping("/findUser/{id}")
    @CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
    public List<CommentsDTO> findComments(@PathVariable String id){
        if (Objects.isNull(id)) {
            return null;
        }
        System.out.println(id);

        List<CommentsDTO> commentsList = commentsService.findAllComments();

        List<CommentsDTO> userComments = new ArrayList<>();

        for (CommentsDTO comment:commentsList) {
            if(comment.getEmail().contains(id)){
                userComments.add(comment);
            }
        }
        return userComments;
    }

    @PostMapping("/deleteComments")
    public void deleteComments(@RequestBody Comments comments){


    }

}
