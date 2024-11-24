package com.taskflow.task.dto;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.task.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private String userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;

    private List<TagDto> tags;
}
