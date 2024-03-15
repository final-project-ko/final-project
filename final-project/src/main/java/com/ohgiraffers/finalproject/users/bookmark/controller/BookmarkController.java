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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

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

    @DeleteMapping("/delete/{userId}/{bookmarkCode}")
    public ResponseEntity<String> deleteBookmark(@PathVariable String userId, @PathVariable Integer bookmarkCode) {
        try {
            bookmarkService.deleteBookmark(userId,bookmarkCode);
            return ResponseEntity.ok().body("북마크가 성공적으로 삭제되었습니다.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("북마크를 삭제하는 중에 오류가 발생했습니다.");
        }
    }

    @Operation(summary = "웹 기사별 북마크 조회", description = "웹 기사별 북마크 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/article")
    public ResponseEntity findByArticle(@RequestBody HashMap<String,String> request) {

        if (request.get("userId").isEmpty()) {
            return ResponseEntity.status(401).body("로그인 정보 없음");
        } else if (request.get("articleCode").isEmpty()) {
            return ResponseEntity.status(402).body("뉴스 정보 없음");
        }

        String userId = request.get("userId");
        int newsCode = Integer.parseInt(request.get("articleCode"));

        BookmarkDTO response = bookmarkService.findByUserAndArticle(userId, newsCode);

        if (response == null) {
            return ResponseEntity.status(404).body("등록된 북마크 없음");
        }

        return ResponseEntity.ok(response);
    }
}
