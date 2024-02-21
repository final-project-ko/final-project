package com.ohgiraffers.finalproject.home.today.keyword.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "홈화면 키워드 정보", description = "홈화면 키워드 정보 관련 api 입니다.")
@RestController
@RequestMapping("/api/keyword")
public class KeywordController {

    @Operation(summary = "키워드 불러오는 메소드", description = "키워드 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "키워드 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping
    public void Keyword(){

    }

}
