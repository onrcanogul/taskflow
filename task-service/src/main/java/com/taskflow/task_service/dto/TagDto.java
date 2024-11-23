package com.taskflow.task_service.dto;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.task_service.entity.Task;
import lombok.Data;

import java.util.List;


@Data
public class TagDto extends BaseDto {
    private String name;

    private List<Task> tasks;
}
