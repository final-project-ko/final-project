package com.ohgiraffers.finalproject.news.comments.service;

import com.ohgiraffers.finalproject.news.comments.dto.CommentsDTO;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.repository.CommentsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentsServiceTest {

    @Mock
    private CommentsRepository commentsRepository;

    @InjectMocks // 의존성 주입을 필요로 하는 모의 객체
    private CommentsService commentsService;

    @BeforeEach
    public void setUp(){
        // MockitoAnnotations을 사용하여 Mock 및 InjectMocks 설정 초기화
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testRegistComment() {
        // Given
        // 주어진 댓글 데이터를 생성하고 설정
        HashMap<String, String> comment = new HashMap<>();
        comment.put("newsCode", "123");
        comment.put("userId", "user123");
        comment.put("email", "user@example.com");
        comment.put("content", "This is a test comment");

        // 저장될 댓글 객체 생성 및 설정
        Comments savedComment = new Comments();
        savedComment.setNewsCode(123);
        savedComment.setUserId("user123");
        savedComment.setEmail("user@example.com");
        savedComment.setContent("This is a test comment");
        savedComment.setDate(LocalDate.now());
        savedComment.setStatus("Y");
        savedComment.setNotify(0);

        // commentsRepository.save() 메소드가 호출될 때 반환될 객체를 설정
        when(commentsRepository.save(any(Comments.class))).thenReturn(savedComment);

        // When
        // 댓글 등록 메소드 실행
        Comments result = commentsService.registComment(comment);

        // Then
        // 반환된 결과가 예상된 값과 일치하는지 확인
        assertEquals(123, result.getNewsCode());
        assertEquals("user123", result.getUserId());
        assertEquals("user@example.com", result.getEmail());
        assertEquals("This is a test comment", result.getContent());
        assertEquals(LocalDate.now(), result.getDate());
        assertEquals("Y", result.getStatus());
        assertEquals(0, result.getNotify());

        // commentsRepository.save() 메소드가 한 번 호출되었는지 확인
        verify(commentsRepository, times(1)).save(any(Comments.class));
    }


    @Test
    public void testFindComments(){

        List<Comments> mockList = new ArrayList<>();
        mockList.add(new Comments());
        when(commentsRepository.findByNewsCode(1)).thenReturn(mockList);

        List<CommentsDTO> result = commentsService.findComments(1);

        Assertions.assertEquals(result.size(), mockList.size());
        verify(commentsRepository, times(1)).findByNewsCode(1);

    }

    @Test
    public void testFindTodayComments(){
        List<Comments> mockList = new ArrayList<>();
        mockList.add(new Comments());
        when(commentsRepository.findByDate(LocalDate.now())).thenReturn(mockList);

        List<CommentsDTO> result = commentsService.findTodayComments(LocalDate.now());

        Assertions.assertEquals(mockList.size() , result.size());
        verify(commentsRepository, times(1)).findByDate(LocalDate.now());
    }




}