package com.thieunm.messaging_api.service.impl;

import com.thieunm.messaging_api.dto.user.RegisterUserRequest;
import com.thieunm.messaging_api.dto.user.UserResponse;
import com.thieunm.messaging_api.entity.User;
import com.thieunm.messaging_api.repository.IUserRepository;
import com.thieunm.messaging_api.service.IUserService;
import com.thieunm.messaging_api.utils.MapperUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

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
        user.setAdmin(false);
        user.setOnline(true);
        user.setLocked(false);
        user.setLastOnlineTime(Timestamp.from(Instant.now()));

        user = userRepository.save(user);

        return MapperUtils.map(user, UserResponse.class);
    }
}
