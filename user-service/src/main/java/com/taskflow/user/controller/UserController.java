package com.taskflow.user.controller;

import com.taskflow.user.dto.UserDto;
import com.taskflow.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable(name = "id") UUID id) {
        return ResponseEntity.status(200).body(service.getById(id));
    }
    @GetMapping("/username/{name}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable(name = "name") String name){
        return ResponseEntity.status(200).body(service.getByName(name));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getById(@PathVariable(name = "email") String email){
        return ResponseEntity.status(200).body(service.getByEmail(email));
    }
    @GetMapping("/me")
    public ResponseEntity<UserDto> getOrCreate(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.status(200).body(service.findOrCreate(jwt.getClaim("id"), jwt.getClaim("username"), jwt.getClaim("email")));
    }
    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        return ResponseEntity.status(200).body(service.update(dto, dto.getId()));
    }
}
