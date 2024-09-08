package com.thieunm.messaging_api.repository.impl;

import com.thieunm.messaging_api.entity.User;
import com.thieunm.messaging_api.repository.IUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepository implements IUserRepository {

    private final EntityManager entityManager;

    public User save(User user) {
        entityManager.merge(user);
        return user;
    }

    public Optional<User> findById(int id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }
}
