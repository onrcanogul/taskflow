package com.taskflow.task_service.service.impl;

import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.shared.service.impl.BaseServiceImpl;
import com.taskflow.task_service.dto.TaskDto;
import com.taskflow.task_service.entity.Task;
import com.taskflow.task_service.service.TaskService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskDto> implements TaskService {
    public TaskServiceImpl(BaseRepository<Task> repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(TaskDto dto, Task entity) {

    }

    @Override
    protected TaskDto mapToDto(Task entity) {
        return null;
    }

    @Override
    protected Task mapToEntity(TaskDto dto) {
        return null;
    }
}

