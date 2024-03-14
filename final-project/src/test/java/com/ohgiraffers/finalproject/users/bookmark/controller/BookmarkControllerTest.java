package com.ohgiraffers.finalproject.users.bookmark.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.users.bookmark.service.BookmarkService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;


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
//    @Test
//    void registBookmark_ReturnBookmark() throws Exception {  // 테스트 메서드는 반환값이 필요없기에 void를 사용한다.
//
//
//
//
//
//
//
//    }





}
