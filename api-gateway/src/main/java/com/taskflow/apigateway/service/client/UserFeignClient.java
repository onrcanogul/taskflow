package com.taskflow.apigateway.service.client;

import com.taskflow.apigateway.dto.client.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users")
public interface UserFeignClient {
    @GetMapping("/me")
    public ResponseEntity<UserDto> getOrCreate(@AuthenticationPrincipal Jwt jwt);
}
