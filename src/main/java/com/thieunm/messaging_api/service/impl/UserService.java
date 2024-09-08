package com.thieunm.messaging_api.service.impl;

import com.thieunm.messaging_api.dto.user.RegisterUserRequest;
import com.thieunm.messaging_api.dto.user.UserResponse;
import com.thieunm.messaging_api.entity.User;
import com.thieunm.messaging_api.enums.RolesEnum;
import com.thieunm.messaging_api.repository.IUserRepository;
import com.thieunm.messaging_api.service.IUserService;
import com.thieunm.messaging_api.utils.MapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse registerUser(RegisterUserRequest request) {
        User user = MapperUtils.map(request, User.class);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(RolesEnum.USER.getCode());
        user = userRepository.save(user);
        UserResponse userResponse = MapperUtils.map(user, UserResponse.class);
        userResponse.setRoleName(RolesEnum.USER.getName());
        return userResponse;
    }
}
