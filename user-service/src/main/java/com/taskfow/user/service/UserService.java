package com.taskfow.user.service;

import com.taskflow.shared.service.BaseService;
import com.taskfow.user.dto.UserDto;
import com.taskfow.user.entity.User;

import java.util.UUID;

public interface UserService extends BaseService<User, UserDto> {
    UserDto findOrCreate(String userId, String username, String email);
    UserDto getById(UUID id);
    UserDto getByName(String username);
    UserDto getByEmail(String email);

}
