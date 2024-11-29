package com.taskflow.user.repository;

import com.taskflow.base.repository.BaseRepository;
import com.taskflow.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
