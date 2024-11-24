package com.taskfow.user.repository;

import com.taskflow.shared.repository.BaseRepository;
import com.taskfow.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
