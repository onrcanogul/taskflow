package com.taskflow.task.service.impl;

import com.taskflow.base.repository.BaseRepository;
import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.entity.Task;
import com.taskflow.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskDto> implements TaskService {
    public TaskServiceImpl(BaseRepository<Task> repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(TaskDto dto, Task entity) {
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setUserId(dto.getUserId());
        entity.setTargetDate(dto.getTargetDate());
        entity.setPoints(dto.getPoints());
        entity.setStatus(dto.getStatus());
        entity.setUpdatedDate(LocalDateTime.now());
    }

    @Override
    protected TaskDto mapToDto(Task entity) {
        TaskDto dto = new TaskDto();
        dto.setUserId(entity.getUserId());
        dto.setDescription(entity.getDescription());
        dto.setTitle(entity.getTitle());
        dto.setPoints(entity.getPoints());
        dto.setTargetDate(entity.getTargetDate());
        dto.setStatus(entity.getStatus());
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedDate());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    @Override
    protected Task mapToEntity(TaskDto dto) {
        Task task = new Task();
        task.setUserId(dto.getUserId());
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setPoints(dto.getPoints());
        task.setTargetDate(dto.getTargetDate());
        task.setStatus(dto.getStatus());
        task.setId(dto.getId());
        task.setCreatedDate(dto.getCreatedAt());
        task.setCreatedBy(dto.getCreatedBy());
        task.setUpdatedDate(dto.getUpdatedAt());
        task.setUpdatedBy(dto.getUpdatedBy());
        return task;
    }
}

