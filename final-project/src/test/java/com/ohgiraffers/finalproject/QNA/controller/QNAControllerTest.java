package com.ohgiraffers.finalproject.QNA.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class QNAControllerTest {

    private MockMvc mockMvc;

    @Mock
    private QnaService qnaService;

    @InjectMocks
    private QNAController qnaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(qnaController).build();
    }

    @Test
    public void testFindAllInquiry() throws Exception {
        // findAllInquiry 메소드에 대한 테스트입니다.

        // QnaService가 반환할 가상의 데이터를 설정합니다.
        List<Inquiry> inquiries = Arrays.asList(new Inquiry(), new Inquiry());
        when(qnaService.findAllInquiry()).thenAnswer(invocation -> inquiries);

        // GET 요청을 보내고 응답을 확인합니다.
        mockMvc.perform(get("/api/qna/findAllInquiry"))
                .andExpect(status().isOk())  // HTTP 상태 코드가 200인지 확인합니다.
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))  // 응답의 컨텐츠 타입이 JSON인지 확인합니다.
                .andExpect(jsonPath("$.articles").isArray())  // JSON 응답에서 articles 필드가 배열인지 확인합니다.
                .andExpect(jsonPath("$.articles.length()").value(2));  // articles 배열의 길이가 2인지 확인합니다.

        // QnaService의 findAllInquiry 메소드가 한 번 호출되었는지 확인합니다.
        verify(qnaService, times(1)).findAllInquiry();
        verifyNoMoreInteractions(qnaService);  // QnaService와의 추가적인 상호작용이 없는지 확인합니다.
    }

    @Test
    public void testFindInquiry() throws Exception {
        String userId = "testUser";
        List<Inquiry> inquiries = Arrays.asList(new Inquiry(), new Inquiry());

        when(qnaService.findUserInquiry(userId)).thenAnswer(invocation -> inquiries);

        mockMvc.perform(get("/api/qna/findInquiry/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(qnaService, times(1)).findUserInquiry(userId);
        verifyNoMoreInteractions(qnaService);
    }

    @Test
    public void testInsertInquiry() throws Exception {
        HashMap<String, String> insertData = new HashMap<>();
        insertData.put("id", "testId");

        when(qnaService.insertInquiry(any(HashMap.class))).thenReturn(new Inquiry());

        mockMvc.perform(post("/api/qna/insertInquiry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(insertData)))
                .andExpect(status().isOk());

        verify(qnaService, times(1)).insertInquiry(any(HashMap.class));
        verifyNoMoreInteractions(qnaService);
    }

    @Test
    public void testDeleteInquiry() throws Exception {
        HashMap<String, String> deleteData = new HashMap<>();
        deleteData.put("id", "testId");

        when(qnaService.deleteInquiry(any(HashMap.class))).thenReturn(1);

        mockMvc.perform(post("/api/qna/deleteInquiry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(deleteData)))
                .andExpect(status().isOk());

        verify(qnaService, times(1)).deleteInquiry(any(HashMap.class));
        verifyNoMoreInteractions(qnaService);
    }

    @Test
    public void testInsertReply() throws Exception {
        HashMap<String, String> insertData = new HashMap<>();
        insertData.put("id", "testId");

        when(qnaService.insertReply(any(HashMap.class))).thenReturn(new Inquiry());

        mockMvc.perform(post("/api/qna/insertReply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(insertData)))
                .andExpect(status().isOk());

        verify(qnaService, times(1)).insertReply(any(HashMap.class));
        verifyNoMoreInteractions(qnaService);
    }

    @Test
    public void testDeleteReply() throws Exception {
        HashMap<String, String> deleteData = new HashMap<>();
        deleteData.put("id", "testId");

        when(qnaService.deleteReply(any(HashMap.class))).thenReturn(1);

        mockMvc.perform(post("/api/qna/deleteReply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(deleteData)))
                .andExpect(status().isOk());

        verify(qnaService, times(1)).deleteReply(any(HashMap.class));
        verifyNoMoreInteractions(qnaService);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}