package com.taskflow.user.service.impl;

import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.user.dto.UserDto;
import com.taskflow.user.entity.User;
import com.taskflow.user.repository.UserRepository;
import com.taskflow.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDto> implements UserService {
    private UserRepository repository;
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }
    public UserDto getById(UUID id) {
        User user = repository.findById(id).orElseThrow(NullPointerException::new);
        return mapToDto(user);
    }

    public UserDto getByName(String username) {
        User user = repository.findByUsername(username).orElseThrow(NullPointerException::new);
        return mapToDto(user);
    }

    public UserDto getByEmail(String email){
        User user = repository.findByEmail(email).orElseThrow(NullPointerException::new); //throwlar düzeltilecek
        return mapToDto(user);
    }

    public UserDto findOrCreate(String userId, String username, String email) {
        return mapToDto(repository.findById(UUID.fromString(userId)).orElseGet(() -> {
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setId(UUID.fromString(userId));
            return repository.save(user);
        }));
    }

    @Override
    protected void updateEntity(UserDto dto, User entity) {
        entity.setUsername(dto.getUsername());
        entity.setEmail(dto.getUsername());
        entity.setLevel(dto.getLevel());
        entity.setPoints(dto.getPoints());
        entity.setUpdatedDate(LocalDateTime.now());
    }

    @Override
    protected UserDto mapToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPoints(entity.getPoints());
        dto.setId(entity.getId());
        dto.setLevel(entity.getLevel());
        dto.setCreatedAt(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setUpdatedAt(entity.getUpdatedDate());
        return dto;
    }

    @Override
    protected User mapToEntity(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPoints(dto.getPoints());
        user.setId(dto.getId());
        user.setLevel(dto.getLevel());
        user.setCreatedDate(dto.getCreatedAt());
        user.setCreatedBy(dto.getCreatedBy());
        user.setUpdatedBy(dto.getUpdatedBy());
        user.setUpdatedDate(dto.getUpdatedAt());
        return user;
    }
}
