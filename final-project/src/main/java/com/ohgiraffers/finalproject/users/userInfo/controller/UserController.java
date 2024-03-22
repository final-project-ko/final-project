package com.ohgiraffers.finalproject.users.userInfo.controller;

import com.ohgiraffers.finalproject.login.kakao.entity.UserEntity;
import com.ohgiraffers.finalproject.users.userInfo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "유저 정보", description = "DB에 담긴 유저 정보 api 입니다.")
@RestController
@RequestMapping("/api/user/*")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @Operation(summary = "어드민 유저 정보 조회 메소드", description = "전체 유저 정보 조회 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/admin")
    public List<UserEntity> adminUserInfo(){
        List<UserEntity> userInfo = userService.adminUserInfo();

        return userInfo;
    }

    @Operation(summary = "sns별 유저 조회 메소드", description = "sns별 가입 인원 조회 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "불러 오기 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @GetMapping("/allUsers")
    public Map<String,Integer> kakaoAndNaver(){

        Map<String,Integer> allUsers = userService.findAllUsers();

        return allUsers;
    }

    @Operation(summary = "어드민 유저 탈퇴 메소드", description = "어드민 권한 유저 탈퇴 메소드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정보 제거 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 정보")
    })
    @PostMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody HashMap<String,String> userId){

        /*System.out.println(userId);*/
        if (userId.isEmpty() || userId.get("userId").isEmpty()){
            return ResponseEntity.status(404).body("그런 유저는 없습니다.");
        }
        String user = userId.get("userId");

        int result = userService.deleteUserInfo(user);
        if (result < 1){
            return ResponseEntity.status(404).body("실패했습니다.");
        }

        return ResponseEntity.ok(result);

    }

}
