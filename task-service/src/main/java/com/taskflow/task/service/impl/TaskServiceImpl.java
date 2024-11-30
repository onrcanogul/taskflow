package com.taskflow.task.service.impl;

import com.taskflow.base.events.TaskSendNotificationEvent;
import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.entity.Task;
import com.taskflow.task.repository.TaskRepository;
import com.taskflow.task.service.TaskService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskDto> implements TaskService {
    private TaskRepository repository;
    private final StreamBridge streamBridge;
    public TaskServiceImpl(TaskRepository repository, StreamBridge streamBridge) {
        super(repository);
        this.repository = repository;
        this.streamBridge = streamBridge;
    }

    public TaskDto create(TaskDto dto) {
        Task task = mapToEntity(dto);
        TaskDto newTask = mapToDto(repository.save(task));
        sendCommunication(newTask, createMessage(newTask));
        return newTask;
    }

    public TaskDto update(TaskDto dto) {
        Task task = repository.findById(dto.getId()).orElseThrow(NullPointerException::new);
        updateEntity(dto, task);
        TaskDto newTask = mapToDto(repository.save(task));
        sendCommunication(newTask, updateMessage(newTask));
        return newTask;
    }

    public void delete(UUID id) {
        Task task = repository.findById(id).orElseThrow(NullPointerException::new);
        repository.delete(task);
        TaskDto dto = mapToDto(task);
        sendCommunication(dto, deleteMessage(dto));
    }


    private void sendCommunication(TaskDto task, String message) {
        TaskSendNotificationEvent event = new TaskSendNotificationEvent();
        event.setUserId(task.getUserId());
        event.setTitle(task.getTitle());
        event.setTargetDate(task.getTargetDate());
        event.setMessage(message);
        streamBridge.send("taskSendNotification-out-0", event);
    }

    private String createMessage(TaskDto task) {
        return "Task - " + task.getTitle() + " - " + "has been created, Target date: " + task.getTargetDate() +".";
    }
    private String updateMessage(TaskDto task) {
        return "Task - " + task.getTitle() + " - " + "has been updated, Target date: " + task.getTargetDate() +".";
    }
    private String deleteMessage(TaskDto task) {
        return "Task - " + task.getTitle() + " - " + "has been deleted.";
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

