package com.ohgiraffers.finalproject.news.category.contents.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ContentsController.class)
class ContentsControllerTest {

    // path 응답.. 익셉션 처리.. 정상적 매개변수 원하는 형식으로 리턴하는지?  .. null값 반환시 원하는 방향으로 리턴하는지..
    @Autowired
    private MockMvc mockMvc; //실제 서버에 배포하지 않고도 테스트를 위한 요청을 제공하는 수단 - get,post 등 요청을 만들어 보낼 수 있음

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NewsService newsService;

    @Test
    void selectNews_ReturnsListOfNewsDTO() throws Exception {
        // 뉴스 서비스가 빈 리스트를 반환하도록 설정
        when(newsService.findAllNews()).thenReturn(new ArrayList<>());

        // GET 요청 수행 및 응답 확인
        mockMvc.perform(get("/api/news/allNews"))
                .andExpect(status().isOk())  // 200번 응답으로 제대로 나오는지 확인
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));  // json 형식으로 응답하는지 확인
    }

    @Test
    void categoryNews_ReturnsArticleDTO() throws Exception {
        // 뉴스 서비스가 빈 리스트를 반환하도록 설정
        when(newsService.categoryNews(any(String.class), any(LocalDate.class))).thenReturn(new ArrayList<>());

        // GET 요청 수행 및 응답 확인
        mockMvc.perform(get("/api/news/categoryNews/{category}", "exampleCategory"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void modifynews_ReturnsModifiedNews() throws Exception {
        // 모킹된 데이터 생성
        HashMap<String, String> news = new HashMap<>();
        news.put("title", "Example Title");

        // 뉴스 서비스가 뉴스 객체를 반환하도록 설정
        when(newsService.modifyNews(any(HashMap.class))).thenReturn(new News());

        // POST 요청 수행 및 응답 확인
        mockMvc.perform(post("/api/news/modifyNews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(news)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void deleteNews_ReturnsDeletedNews() throws Exception {
        // 모킹된 데이터 생성
        HashMap<String, String> news = new HashMap<>();
        news.put("title", "Example Title");

        // 뉴스 서비스가 뉴스 객체를 반환하도록 설정
        when(newsService.deleteNews(any(HashMap.class))).thenReturn(new News());

        // POST 요청 수행 및 응답 확인
        mockMvc.perform(post("/api/news/deleteNews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(news)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}