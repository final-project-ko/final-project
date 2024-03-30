package com.ohgiraffers.finalproject.notice.service;

import com.ohgiraffers.finalproject.notice.repository.NoticeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NoticeServiceTest {

    @Mock
    private NoticeRepository noticeRepository;

    @InjectMocks
    private NoticeService noticeService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInsertNotice(){

        HashMap<String,String> notice = new HashMap<>();

    }

    @Test
    public void testFindInputNotice(){

    }

    @Test
    public void testFindAllNotice(){

    }

    @Test
    public void testModifyNotice(){

    }

    @Test
    public void testDeleteNotice(){
        
    }

}