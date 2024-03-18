package com.ohgiraffers.finalproject.users.bookmark.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.users.bookmark.dto.BookmarkDTO;
import com.ohgiraffers.finalproject.users.bookmark.entity.Bookmark;
import com.ohgiraffers.finalproject.users.bookmark.service.BookmarkService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// MOCK - 테스트 중에 실제 객체를 대신하여 행동을 모방하는 객체로, 테스트의 격리성을 유지하고 의존성을 제어하기 위해 사용한다.
@ExtendWith(SpringExtension.class) // Spring MVC 테스트를 위한 확장을 사용
@WebMvcTest(BookmarkController.class) // BookmarkController를  MVC 대상으로 설정
class BookmarkControllerTest { //일반적으로 테스트 클래스는 다른 패키지에서 접근할 필요가 없으므로, 보통 테스트 클래스에서는 public 접근 제어자를 사용하지 않는다.

    @Autowired
    private MockMvc mockMvc; //MockMvc 객체를 사용하여 BookmarkController의 메서드를 호출하고 반환값이 올바른지, HTTP 응답이 올바른지 등을 테스트할 수 있습니다.

    @Autowired
    private ObjectMapper objectMapper;   //JSON과 Java 객체 간의 변환을 담당하는 클래스입니다. 스프링이 자동으로 ObjectMapper 빈을 찾아서 이 필드에 주입해줍니다. 이렇게 하면 개발자는 직접 ObjectMapper 객체를 생성하고 관리할 필요 없이 스프링이 알아서 필요한 빈을 주입해주므로 코드가 간결해지고 유지보수가 쉬워집니다.

    // 해당 서비스를 Mock으로 설정합니다.
    @MockBean
    private BookmarkService bookmarkService;

    // 해당 뉴스를 북마크 테이블에 등록하는 테스트 메소드
    @Test
    void registBookmark_SuccessfullyRegistered_ReturnsBookmark() throws Exception {
        // 테스트에 사용할 북마크 DTO 생성
        BookmarkDTO bookmarkDTO = new BookmarkDTO();
        bookmarkDTO.setTitle("Sample Title");
        bookmarkDTO.setDescription("Sample Description");
        bookmarkDTO.setUrl("https://example.com");
        bookmarkDTO.setImage("https://example.com/image.jpg");
        bookmarkDTO.setUserId("sampleUser");

        // 북마크 서비스가 등록한 북마크를 나타내는 객체 생성
        Bookmark savedBookmark = new Bookmark();
        savedBookmark.setBookmarkCode(1);
        savedBookmark.setTitle("Sample Title");
        savedBookmark.setDescription("Sample Description");
        savedBookmark.setUrl("https://example.com");
        savedBookmark.setImage("https://example.com/image.jpg");
        savedBookmark.setUserId("sampleUser");

        // 북마크 서비스의 동작을 설정하여 등록 성공 시 반환할 북마크 객체를 지정합니다.
        when(bookmarkService.registBookmark(any(BookmarkDTO.class))).thenReturn(savedBookmark);

        // HTTP POST 요청을 보내고, 응답이 정상적으로 처리되어 등록된 북마크를 반환하는지 확인합니다.
        mockMvc.perform(post("/api/bookmark/regist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookmarkDTO)))
                .andExpect(status().isOk());  // HTTP 응답 상태 코드가 200(OK)인지 확인합니다.
    }




}
