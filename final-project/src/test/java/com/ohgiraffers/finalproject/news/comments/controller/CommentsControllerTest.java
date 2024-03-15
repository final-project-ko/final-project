package com.ohgiraffers.finalproject.news.comments.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.news.comments.dto.CommentsDTO;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.service.CommentsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CommentsController.class)
class CommentsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CommentsService commentsService;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRegistComment() throws Exception {
        HashMap<String,String> insertData = new HashMap<>();
        insertData.put("newsCode","test");
        insertData.put("email","test");
        insertData.put("content","test");
        
        Mockito.when(commentsService.registComment(any(HashMap.class))).thenReturn(new Comments());
                        // 반환해줄 임의의 데이터 지정
        mockMvc.perform(MockMvcRequestBuilders.post("/api/comments/regist")  // 요청 수행 응답 확인
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(insertData))) //컨트롤러 전송부분
                .andExpect(status().isOk());  // 200번대 나오면 통과

        verify(commentsService, times(1)).registComment(any(HashMap.class));
        verifyNoMoreInteractions(commentsService);
        // 메소드가 정확히 1번 호출되었고, 그 외의 상호작용은 없었음을 의미함...

    }


    @Test
    public void testFindComments() throws Exception {
        int newsCode = 123; // 테스트할 뉴스 코드

        // 테스트용 댓글 목록 생성
        List<CommentsDTO> mockList = new ArrayList<>();
        mockList.add(new CommentsDTO());

        // CommentsService의 findComments 메서드가 호출될 때 mockList를 반환하도록 설정
        when(commentsService.findComments(newsCode)).thenReturn(mockList);

        // 컨트롤러 메서드 호출 및 테스트
        mockMvc.perform(MockMvcRequestBuilders.get("/api/comments/find/{newsCode}", newsCode)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(mockList)))
                .andExpect(status().isOk()); // HTTP 상태코드가 200인지 확인

        // CommentsService의 findComments 메서드가 newsCode 인자와 함께 1회 호출되었는지 검증
        verify(commentsService, times(1)).findComments(newsCode);
    }

    @Test
    public void testUserComments() throws Exception {
        LocalDate testDate = LocalDate.of(2024, Month.MARCH, 14);
        // 테스트 안정성 보장을 위해 LocalDate.now() 말고 임의의 날짜를 입력 해야함..

        List<CommentsDTO> mockList = new ArrayList<>();
        mockList.add(new CommentsDTO());

        when(commentsService.findTodayComments(testDate)).thenReturn(mockList);
        List<CommentsDTO> result = commentsService.findTodayComments(testDate);
        Assertions.assertEquals(mockList,result);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/comments/userComments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockList)))
                        .andExpect(status().isOk());

        verify(commentsService, times(1)).findTodayComments(testDate);
    }

    @Test
    public void testAllComments(){

    }

}