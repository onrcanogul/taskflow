package com.taskflow.task.dto;

import com.taskflow.base.dto.BaseDto;
import com.taskflow.task.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class TaskDto extends BaseDto {
    private String title;
    private String description;
    private UUID userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;

    private List<TagDto> tags = new ArrayList<>();
}
