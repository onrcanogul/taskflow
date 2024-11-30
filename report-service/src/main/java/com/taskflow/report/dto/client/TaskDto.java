package com.taskflow.report.dto.client;

import com.taskflow.base.dto.BaseDto;
import com.taskflow.base.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private UUID userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;
}
