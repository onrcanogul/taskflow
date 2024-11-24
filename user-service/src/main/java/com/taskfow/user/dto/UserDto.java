package com.taskfow.user.dto;

import com.taskflow.shared.dto.BaseDto;
import lombok.Data;

@Data
public class UserDto extends BaseDto {
    private String username;
    private String email;
    private int level;
    private int points;


}
