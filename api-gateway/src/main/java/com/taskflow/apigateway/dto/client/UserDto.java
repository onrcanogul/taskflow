package com.taskflow.apigateway.dto.client;

import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor @AllArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private int level;
    private int points;
}
