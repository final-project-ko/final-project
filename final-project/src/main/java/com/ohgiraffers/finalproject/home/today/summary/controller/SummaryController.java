package com.ohgiraffers.finalproject.home.today.summary.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "홈화면 요약 뉴스", description = "홈화면에 표시할 요약 뉴스 api 입니다.")
@RestController
@RequestMapping("/api/Summary")
public class SummaryController {

    @Operation(summary = "요약 뉴스 불러오는 메소드", description = "요약 뉴스 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "요약 뉴스 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/view")
    public void Summary(){
        
    }

    @Operation(summary = "요약 뉴스 읽어 주는 메소드", description = "뉴스 읽어 주는 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "읽어 주기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/listen")
    public void listen(){

    }


}
