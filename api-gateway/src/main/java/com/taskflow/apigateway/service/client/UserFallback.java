package com.taskflow.apigateway.service.client;

import com.taskflow.apigateway.dto.client.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class UserFallback implements UserFeignClient{
    @Override
    public ResponseEntity<UserDto> getOrCreate(Jwt jwt) {
        return null;
    }
}
