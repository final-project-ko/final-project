package com.ohgiraffers.finalproject.users.bookmark.controller;


import com.ohgiraffers.finalproject.notice.dto.NoticeDTO;
import com.ohgiraffers.finalproject.users.bookmark.dto.BookmarkDTO;
import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import com.ohgiraffers.finalproject.users.bookmark.service.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "북마크", description = "해당 뉴스의 북마크 api")
@RestController
@RequestMapping("/api/bookmark")
@CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081", "exp://192.168.0.63:8080"})
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;
    @Operation(summary = "뉴스 북마크 등록", description = "뉴스 북마크 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/regist")
    public ResponseEntity registBookmark(@RequestBody BookmarkDTO bookmarkDTO){

        Bookmark registBookmark = bookmarkService.registBookmark(bookmarkDTO);

        return ResponseEntity.ok(registBookmark);

    }

    @Operation(summary = "북마크 전체 조회", description = "전체 북마크 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/find/{userId}")
    public List<BookmarkDTO> findBookmark(@PathVariable String userId){
        System.out.println(userId);
        List<BookmarkDTO> result = bookmarkService.findByBookmark(userId);


        System.out.println("Whghl"+result);
        return result;
    }



}
