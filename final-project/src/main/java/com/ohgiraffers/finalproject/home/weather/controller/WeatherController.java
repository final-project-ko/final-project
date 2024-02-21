package com.ohgiraffers.finalproject.home.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "날씨 정보", description = "날씨 정보 관련 api 입니다.")
@RestController
@RequestMapping("/api/weathers")
public class WeatherController {

    @Operation(summary = "날씨 불러오는 메서드", description = "날씨 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "날씨 불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping
    public void weather() {

    }
}