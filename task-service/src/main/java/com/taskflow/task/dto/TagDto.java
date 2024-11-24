package com.taskflow.task.dto;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.task.entity.Task;
import lombok.Data;

import java.util.List;


@Data
public class TagDto extends BaseDto {
    private String name;

    private List<Task> tasks;
}
