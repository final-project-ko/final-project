package com.ohgiraffers.finalproject.news.category.contents.service;

import com.ohgiraffers.finalproject.news.category.contents.dto.NewsDTO;
import com.ohgiraffers.finalproject.news.category.contents.entity.News;
import com.ohgiraffers.finalproject.news.category.contents.repository.NewsRepository;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewsServiceTest {

    @Mock
    private NewsRepository newsRepository;

    @InjectMocks
    private NewsService newsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        // initMock deprecated -> openMocks 으로 다른건 대체함
    }

    @Test
    public void testFindAllNews() {
        // Mock 객체를 사용하여 findAll 메서드가 호출될 때 반환할 데이터 설정
        List<News> mockNewsList = new ArrayList<>();
        when(newsRepository.findAll()).thenReturn(mockNewsList);

        // 테스트할 서비스 메서드 호출
        List<NewsDTO> result = newsService.findAllNews();

        // 결과 검증
        assertEquals(mockNewsList.size(), result.size());
        verify(newsRepository, times(1)).findAll(); // findAll 메서드가 한 번 호출되었는지 확인
    }

    @Test
    public void testCategoryNews() {
        // Mock 객체를 사용하여 findByCategoryAndDate 메서드가 호출될 때 반환할 데이터 설정
        List<News> mockNewsList = new ArrayList<>();
        mockNewsList.add(new News());
        when(newsRepository.findByCategoryAndDate(anyString(), any(LocalDate.class))).thenReturn(mockNewsList);

        // 테스트할 서비스 메서드 호출
        List<NewsDTO> result = newsService.categoryNews("TestCategory", LocalDate.now());

        // 결과 검증
        assertEquals(mockNewsList.size(), result.size());
        verify(newsRepository, times(1)).findByCategoryAndDate(anyString(), any(LocalDate.class)); // findByCategoryAndDate 메서드가 한 번 호출되었는지 확인
    }

    @Test
    public void testModifyNews() {
        // 테스트할 데이터 설정
        HashMap<String, String> newsData = new HashMap<>();
        newsData.put("code", "1");
        newsData.put("title", "TestTitle");
        // 나머지 필드들도 필요에 따라 추가

        // 테스트할 서비스 메서드 호출
        News result = newsService.modifyNews(newsData);

        // 결과 검증
        verify(newsRepository, times(1)).save(any(News.class)); // save 메서드가 한 번 호출되었는지 확인
    }

    @Test
    public void testDeleteNews() {
        // 테스트할 데이터 설정
        HashMap<String, String> newsData = new HashMap<>();
        newsData.put("code", "1");
        newsData.put("title", "TestTitle");
        // 나머지 필드들도 필요에 따라 추가

        // 테스트할 서비스 메서드 호출
        News result = newsService.deleteNews(newsData);

        // 결과 검증
        verify(newsRepository, times(1)).save(any(News.class)); // save 메서드가 한 번 호출되었는지 확인
    }
}
