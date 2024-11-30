package com.taskflow.task.service;

import com.taskflow.base.service.BaseService;
import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.entity.Task;

import java.util.UUID;

public interface TaskService extends BaseService<Task, TaskDto> {
    TaskDto create(TaskDto dto);
    TaskDto update(TaskDto dto);
    void delete(UUID id);
}
