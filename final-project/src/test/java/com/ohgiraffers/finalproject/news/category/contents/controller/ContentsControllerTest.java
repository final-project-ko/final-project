package com.ohgiraffers.finalproject.news.category.contents.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.ohgiraffers.finalproject.news.category.contents.dto.ArticleDTO;
import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.service.NewsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ContentsController.class)
class ContentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NewsService newsService;

    @Test
    void testSelectNews() throws Exception {
        List<NewsDTO> mockNewsDTOList = new ArrayList<>();
        // 모의 데이터를 채워넣어주세요.

        when(newsService.findAllNews()).thenReturn(mockNewsDTOList);

        mockMvc.perform(get("/api/news/allNews"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        // 기대하는 반환값을 검증할 수 있는 코드를 작성해주세요.
    }

    @Test
    void testCategoryNews() throws Exception {
        String category = "someCategory";
        LocalDate today = LocalDate.now();

        ArticleDTO mockArticleDTO = new ArticleDTO();
        List<NewsDTO> mockNewsDTOList = new ArrayList<>();
        // 모의 데이터를 채워넣어주세요.

        mockArticleDTO.setArticles(mockNewsDTOList);

        when(newsService.categoryNews(category,today)).thenReturn(mockArticleDTO.getArticles());

        mockMvc.perform(get("/api/news/categoryNews/{category}", category))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        // 기대하는 반환값을 검증할 수 있는 코드를 작성해주세요.
    }

    @Test
    void testModifyNews() throws Exception {
        // 수정 테스트를 위한 모의 데이터와 결과를 만들어주세요.
    }

    @Test
    void testDeleteNews() throws Exception {
        // 삭제 테스트를 위한 모의 데이터와 결과를 만들어주세요.
    }
}