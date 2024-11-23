package com.taskflow.task_service.dto;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.task_service.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private String tags; //gonna be list
    private String userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;
}
