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
import java.util.Objects;

@Tag(name = "북마크", description = "해당 뉴스의 북마크 api")
@RestController
@RequestMapping("/api/bookmark")
@CrossOrigin(origins = "*")
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
        } else if (request.get("newsCode").isEmpty()) {
            return ResponseEntity.status(402).body("뉴스 정보 없음");
        }

        String userId = request.get("userId");
        int newsCode = Integer.parseInt(request.get("newsCode"));

        BookmarkDTO response = bookmarkService.findByUserAndArticle(userId, newsCode);

        if (response == null) {
            return ResponseEntity.status(404).body("등록된 북마크 없음");
        }

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "북마크 등록", description = "북마크 등록 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/registBookmark")
    public ResponseEntity registWebBookmark(@RequestBody HashMap<String,String> request) {

        if (Objects.isNull(request.get("userId"))) {
            return ResponseEntity.status(401).body("유저 정보가 없습니다.");
        } else if (Objects.isNull(request.get("newsCode"))) {
            return ResponseEntity.status(402).body("newsCode가 없습니다.");
        } else if (Objects.isNull(request.get("newsTitle"))) {
            return ResponseEntity.status(403).body("newsTitle가 없습니다.");
        } else if (Objects.isNull(request.get("newsDescription"))) {
            return ResponseEntity.status(404).body("newsDescription가 없습니다.");
        } else if (Objects.isNull(request.get("newsUrl"))) {
            return ResponseEntity.status(405).body("newsUrl가 없습니다.");
        } else if (Objects.isNull(request.get("newsImage"))) {
            return ResponseEntity.status(406).body("newsImage가 없습니다.");
        }

        Bookmark response = bookmarkService.registWebBookmark(request);

        if (Objects.isNull(response)) {
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "북마크 삭제", description = "북마크 삭제 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/deleteBookmark")
    public ResponseEntity deleteWebBookmark(@RequestBody HashMap<String,String> request) {

        String userId = request.get("userId");
        int bookmarkCode = Integer.parseInt(request.get("bookmarkCode"));
        System.out.println("userId : " + userId);
        System.out.println("bookmarkCode : " + bookmarkCode);

        int response = bookmarkService.deleteWebBookmark(userId, bookmarkCode);

        if (response == 1) {
            return ResponseEntity.ok().body("삭제 완료");
        } else {
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }
    }


    @Operation(summary = "유저 북마크 조회", description = "유저 북마크 조회 메소드")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/userBookMark/{userId}")
    public List<HashMap<String,String>> userBookMark(@PathVariable String userId){
        if(userId.isEmpty()){
            return null;
        }
        List<HashMap<String,String>> bookmarkList = bookmarkService.findByWebBookmark(userId);

        if (bookmarkList.isEmpty()){
            return null;
        }
        return bookmarkList;
    }

}
