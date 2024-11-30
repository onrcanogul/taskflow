package com.taskflow.notification.service.client;

import com.taskflow.notification.dto.client.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FeignClient(name = "users")
public interface UserFeignClient {
    @GetMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<UserDto> getById(UUID id);
}
