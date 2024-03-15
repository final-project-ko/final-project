package com.ohgiraffers.finalproject.notice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.notice.dto.NoticeDTO;
import com.ohgiraffers.finalproject.notice.service.NoticeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// Spring MVC 테스트를 위한 확장을 사용합니다.
@ExtendWith(SpringExtension.class)
// NoticeController를 웹 MVC 테스트 대상으로 설정합니다.
@WebMvcTest(NoticeController.class)
class NoticeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private NoticeService noticeService;


    @Test
    void allNotice_ReturnsListOfNoticeDTO() throws Exception {
        // 공지사항 목록을 생성
        List<NoticeDTO> noticeList = new ArrayList<>();
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeList.add(noticeDTO);

        // noticeService.findAllNotice()가 호출될 때 noticeList를 반환하도록 설정
        when(noticeService.findAllNotice()).thenReturn(noticeList);


        mockMvc.perform(get("/api/notice/allNotice"))
                .andExpect(status().isOk()) // HTTP 응답 상태 코드가 200인지 확인
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)); // 응답의 컨텐츠 타입이 JSON 형식인지 확인
    }

    @Test
    void searchNotice_ReturnsListOfNoticeDTO() throws Exception {
        // 검색할 텍스트를 설정
        String inputText = "exampleInputText";

        List<NoticeDTO> noticeList = new ArrayList<>();
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeList.add(noticeDTO);

        when(noticeService.findInputNotice(inputText)).thenReturn(noticeList);


        mockMvc.perform(get("/api/notice/searchNotice/{inputText}", inputText))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


}