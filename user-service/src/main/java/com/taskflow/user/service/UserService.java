package com.taskflow.user.service;

import com.taskflow.base.service.BaseService;
import com.taskflow.user.dto.UserDto;
import com.taskflow.user.entity.User;

import java.util.UUID;

public interface UserService extends BaseService<User, UserDto> {
    UserDto findOrCreate(String userId, String username, String email);
    UserDto getById(UUID id);
    UserDto getByName(String username);
    UserDto getByEmail(String email);
}
