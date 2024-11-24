package com.taskfow.user.dto;

import com.taskflow.shared.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserDto extends BaseDto {
    private String username;
    private String email;
    private int level;
    private int points;


}
