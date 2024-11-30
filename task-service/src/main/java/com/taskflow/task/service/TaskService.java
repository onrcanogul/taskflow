package com.taskflow.task.service;

import com.taskflow.base.service.BaseService;
import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService extends BaseService<Task, TaskDto> {
    List<TaskDto> getCompletedTasks(UUID userId);
    TaskDto create(TaskDto dto);
    void addTag(UUID taskId, UUID tagId);
    TaskDto update(TaskDto dto);
    void delete(UUID id);
}
