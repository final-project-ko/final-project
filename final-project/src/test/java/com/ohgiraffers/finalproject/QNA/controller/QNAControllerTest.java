package com.ohgiraffers.finalproject.QNA.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.service.QnaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(QNAController.class)
@AutoConfigureMockMvc
public class QNAControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QnaService qnaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    // 전체 Q&A 조회 테스트
    public void selectAll_ReturnsQnAArticleDTO() throws Exception {
        // Mock QnADTO 목록 생성
        List<QnADTO> qnaList = new ArrayList<>();
        QnADTO qnaDTO = new QnADTO();
        // 필요한 필드를 qnaDTO에 추가

        qnaList.add(qnaDTO);

        when(qnaService.findAllInquiry()).thenReturn(qnaList);

        mockMvc.perform(get("/api/qna/findAllInquiry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.articles").exists())
                .andExpect(jsonPath("$.articles[0].fieldName").value("expectedValue"));
    }

    @Test
// 특정 사용자의 Q&A 조회 테스트
    public void selectInquiry_ReturnsQnADTOList() throws Exception {
        // Mock QnADTO 목록 생성
        List<QnADTO> qnaList = new ArrayList<>();
        QnADTO qnaDTO = new QnADTO();
        // 필요한 필드를 qnaDTO에 추가

        qnaList.add(qnaDTO);

        String userId = "testUserId";

        when(qnaService.findUserInquiry(userId)).thenReturn(qnaList);

        mockMvc.perform(get("/api/qna/findInquiry/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].actualFieldName").value("expectedValue"))
                .andDo(result -> {
                    String content = result.getResponse().getContentAsString();
                    System.out.println("Response Content: " + content);
                });
    }
    @Test
    // Q&A 등록 테스트
    public void insertInquiry_WithValidData_ReturnsInquiry() throws Exception {
        HashMap<String, String> insertData = new HashMap<>();
        // 필요한 필드를 insertData에 추가

        Inquiry mockInquiry = new Inquiry();
        // 필요한 필드를 mockInquiry에 추가

        when(qnaService.insertInquiry(any(HashMap.class))).thenReturn(mockInquiry);

        mockMvc.perform(post("/api/qna/insertInquiry")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(insertData)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fieldName").value("expectedValue"));
    }

    // 다른 메소드에 대한 테스트도 유사하게 작성 가능

}
