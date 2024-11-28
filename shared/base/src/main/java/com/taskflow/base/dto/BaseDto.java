package com.taskflow.base.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class BaseDto {
    private UUID id;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
