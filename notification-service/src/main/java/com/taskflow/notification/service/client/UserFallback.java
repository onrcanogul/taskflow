package com.taskflow.notification.service.client;

import com.taskflow.notification.dto.client.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserFallback implements UserFeignClient {
    @Override
    public ResponseEntity<UserDto> getById(UUID id) {
        return null;
    }
}
