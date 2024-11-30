package com.taskflow.notification.dto.client;

import com.taskflow.base.dto.BaseDto;
import lombok.*;


@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class UserDto extends BaseDto {
    private String username;
    private String email;
    private int level;
    private int points;
}
