package com.thieunm.messaging_api.repository;

import com.thieunm.messaging_api.entity.User;

import java.util.Optional;

public interface IUserRepository {

    User save(User user);

    Optional<User> findById(int id);
}
