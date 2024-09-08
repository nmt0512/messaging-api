package com.thieunm.messaging_api.service;

import com.thieunm.messaging_api.dto.user.RegisterUserRequest;
import com.thieunm.messaging_api.dto.user.UserResponse;

public interface IUserService {

    UserResponse registerUser(RegisterUserRequest request);
}
