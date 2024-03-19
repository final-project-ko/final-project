package com.ohgiraffers.finalproject.news.comments.service;

import com.ohgiraffers.finalproject.news.comments.repository.CommentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CommentsServiceTest {

    @Mock
    private CommentsRepository commentsRepository;

    @InjectMocks // 의존성 주입을 필요로 하는 모의 객체
    private CommentsService commentsService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
}