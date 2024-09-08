package com.thieunm.messaging_api.controller;

import com.thieunm.messaging_api.dto.BaseResponse;
import com.thieunm.messaging_api.dto.user.RegisterUserRequest;
import com.thieunm.messaging_api.dto.user.UserResponse;
import com.thieunm.messaging_api.service.IUserService;
import com.thieunm.messaging_api.utils.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    ResponseEntity<BaseResponse<UserResponse>> registerUser(@RequestBody @Valid RegisterUserRequest request) {
        return ResponseUtils.success(userService.registerUser(request));
    }
}
