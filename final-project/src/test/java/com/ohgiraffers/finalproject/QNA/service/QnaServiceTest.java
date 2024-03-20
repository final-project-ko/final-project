package com.ohgiraffers.finalproject.QNA.service;

import com.ohgiraffers.finalproject.QNA.dto.QnADTO;
import com.ohgiraffers.finalproject.QNA.entity.Inquiry;
import com.ohgiraffers.finalproject.QNA.repository.InquiryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QnaServiceTest {


    @Mock // 모의 객체 생성
    private InquiryRepository inquiryRepository;

    @InjectMocks  // 의존성 주입을 필요로 하는 모의 객체
    private QnaService qnaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUserInquiry(){
        String id = "-928834404";
        // mock 객체를 이용해 반환 데이터 설정
        List<Inquiry> mockQnAList = new ArrayList<>();
        when(inquiryRepository.findByUserId(id)).thenReturn(mockQnAList);

        //테스트 메소드
        List<QnADTO> result = qnaService.findUserInquiry(id);

        //검증
        assertEquals(mockQnAList.size(), result.size());
        verify(inquiryRepository, times(1)).findByUserId(id);


    }

    @Test
    public void testFindAllInquiry(){

        List<Inquiry> mockList = new ArrayList<>();
        when(inquiryRepository.findAll()).thenReturn(mockList);

        List<QnADTO> result = qnaService.findAllInquiry();

        assertEquals(mockList.size(), result.size());
        verify(inquiryRepository, times(1)).findAll();


    }


}