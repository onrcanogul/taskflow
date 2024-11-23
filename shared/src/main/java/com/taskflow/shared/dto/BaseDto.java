package com.taskflow.shared.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseDto {
    private Long id;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
