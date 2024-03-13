package com.ohgiraffers.finalproject.users.userInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.users.userInfo.service.UserService;
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
import java.util.Map;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    // 어드민 유저 정보 조회 테스트
    public void adminUserInfo_ReturnsUserEntityList() throws Exception {
        // Mock UserEntity 목록 생성
        List<UserEntity> userList = new ArrayList<>();
        UserEntity userEntity = new UserEntity();
        // 필요한 필드를 userEntity에 추가

        userList.add(userEntity);

        when(userService.adminUserInfo()).thenReturn(userList);

        mockMvc.perform(get("/api/user/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fieldName").value("expectedValue"));
    }

    @Test
    // sns별 유저 조회 테스트
    public void kakaoAndNaver_ReturnsMap() throws Exception {
        Map<String, Integer> userMap = new HashMap<>();
        // 필요한 필드를 userMap에 추가

        when(userService.findAllUsers()).thenReturn(userMap);

        mockMvc.perform(get("/api/user/allUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fieldName").value("expectedValue"));
    }

    // 다른 메소드에 대한 테스트도 유사하게 작성 가능

}
