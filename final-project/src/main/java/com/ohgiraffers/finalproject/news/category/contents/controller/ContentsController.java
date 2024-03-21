package com.ohgiraffers.finalproject.news.category.contents.controller;

import com.ohgiraffers.finalproject.news.category.contents.dto.ArticleDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

// DB에서 조회하는 뉴스
@Tag(name = "뉴스 정보", description = "DB에 담긴 뉴스 정보 api 입니다.")
@RestController
@RequestMapping("/api/news")
public class ContentsController {

    @Autowired
    private NewsService newsService;


    @Operation(summary = "전체 뉴스 조회 메소드", description = "전체 뉴스를 조회하는 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "뉴스 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/allNews")
    public List<NewsDTO> selectNews() {

        List<NewsDTO> result = newsService.findAllNews();
        if(Objects.isNull(result)){

            return null;
        }

        return result;

    }

    @Operation(summary = "해당 카테고리 뉴스 조회 메소드", description = "카테고리 별 뉴스 조회 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/categoryNews/{category}")
//    @CrossOrigin(origins = "http://localhost:3000")
    @CrossOrigin(origins = {"http://localhost:3000", "exp://192.168.0.63:8081", "exp://172.30.1.26:8081"})
    public ArticleDTO categoryNews(@PathVariable String category) {
        LocalDate today = LocalDate.now();
        System.out.println(category);
        List<NewsDTO> result = newsService.categoryNews(category, today);
        if(Objects.isNull(result)){

            return null;
        }

        List<NewsDTO> newsList = new ArrayList<>();
        int count = 0;

        for (NewsDTO news : result) {
            if (count >= 10) {
                break;
            }
            newsList.add(news);
            count++;
        }
        System.out.println(newsList);

        ArticleDTO articles = new ArticleDTO();
        articles.setArticles(newsList);

        return articles;
    }

    @Operation(summary = "어드민 뉴스 수정 메소드", description = "어드민 유저 뉴스 수정 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 수정 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/modifyNews")
    public ResponseEntity modifynews(@RequestBody HashMap<String,String> news){

        if (Objects.isNull(news)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        System.out.println(news.get("title"));
        News modifyNews = newsService.modifyNews(news);

        if(Objects.isNull(modifyNews)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(modifyNews);
    }




    @Operation(summary = "어드민 뉴스 삭제 메소드", description = "어드민 유저 뉴스 삭제 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = " 삭제 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/deleteNews")
    public ResponseEntity deleteNews(@RequestBody HashMap<String,String> news){

        if (Objects.isNull(news)){
            return ResponseEntity.status(404).body("내용이 없습니다.");
        }

        System.out.println(news.get("title"));
        News deleteNews = newsService.deleteNews(news);

        if(Objects.isNull(deleteNews)){
            return ResponseEntity.status(500).body("서버에서 오류 발생");
        }

        return ResponseEntity.ok(deleteNews);
    }
}
