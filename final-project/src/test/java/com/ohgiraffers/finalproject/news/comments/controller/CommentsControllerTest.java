package com.ohgiraffers.finalproject.news.comments.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.news.comments.entity.Comments;
import com.ohgiraffers.finalproject.news.comments.service.CommentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.HashMap;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CommentsController.class)
@AutoConfigureMockMvc
public class CommentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentsService commentsService;

    @Test
    // 댓글 등록 테스트
    public void registComment_ReturnsResponseEntity() throws Exception {
        HashMap<String, String> comment = new HashMap<>();
        // comment에 필요한 필드 추가

        when(commentsService.registComment(any())).thenReturn(new Comments()); // any  Mockito에서 사용되는 메서드로, 어떠한 타입의 객체도 허용한다는 것을 의미

        mockMvc.perform(post("/api/comments/regist")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(comment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fieldName").value("expectedValue"));
    }

    @Test
    // 댓글 조회 테스트
    public void findComments_ReturnsCommentDTOList() throws Exception {
        int newsCode = 123;

        // commentsService.findComments(newsCode)에 대한 Mock 설정

        mockMvc.perform(get("/api/comments/find/{newsCode}", newsCode))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fieldName").value("expectedValue"));
    }

    @Test
    // 오늘 댓글 조회 테스트
    public void userComments_ReturnsCommentDTOList() throws Exception {
        // commentsService.findTodayComments(LocalDate.now())에 대한 Mock 설정

        mockMvc.perform(get("/api/comments/userComments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fieldName").value("expectedValue"));
    }

    @Test
    // 전체 댓글 조회 테스트
    public void allComments_ReturnsCommentDTOList() throws Exception {
        // commentsService.findAllComments()에 대한 Mock 설정

        mockMvc.perform(get("/api/comments/allComments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fieldName").value("expectedValue"));
    }

    @Test
    // 유저별 댓글 조회 테스트
    public void findComments_ReturnsUserCommentDTOList() throws Exception {
        String id = "exampleUserId";

        // commentsService.findAllComments()에 대한 Mock 설정

        mockMvc.perform(get("/api/comments/findUser/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fieldName").value("expectedValue"));
    }

    @Test
    // 신고 댓글 삭제 테스트
    public void deleteComments_SuccessfulDeletion() throws Exception {
        // 필요한 Mock 설정

        mockMvc.perform(post("/api/comments/deleteComments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new Comments())))
                .andExpect(status().isOk());
    }

    // 다른 메소드에 대한 테스트도 유사하게 작성 가능

    // 객체를 JSON 문자열로 변환하는 메소드
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

