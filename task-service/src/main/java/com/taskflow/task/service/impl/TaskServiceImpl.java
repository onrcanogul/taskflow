package com.taskflow.task.service.impl;

import com.taskflow.base.enums.TaskStatus;
import com.taskflow.base.events.TaskCreateReportEvent;
import com.taskflow.base.events.TaskSendNotificationEvent;
import com.taskflow.base.events.base.IEvent;
import com.taskflow.base.exceptions.NotFoundException;
import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.entity.Tag;
import com.taskflow.task.entity.Task;
import com.taskflow.task.repository.TagRepository;
import com.taskflow.task.repository.TaskRepository;
import com.taskflow.task.service.TaskService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class TaskServiceImpl extends BaseServiceImpl<Task, TaskDto> implements TaskService {
    private final TaskRepository repository;
    private final StreamBridge streamBridge;
    private final TagRepository tagRepository;
    public TaskServiceImpl(TaskRepository repository, StreamBridge streamBridge, TagRepository tagRepository) {
        super(repository);
        this.repository = repository;
        this.streamBridge = streamBridge;
        this.tagRepository = tagRepository;
    }

    public List<TaskDto> getCompletedTasks(UUID userId) {
        return repository.findByUserIdAndStatus(userId, TaskStatus.Done).stream().map(this::mapToDto).toList();
    }

    public TaskDto create(TaskDto dto) {
        Task task = mapToEntity(dto);
        TaskDto newTask = mapToDto(repository.save(task));
        sendCommunication(new TaskSendNotificationEvent(dto.getUserId(), dto.getTitle(), dto.getTargetDate(), createMessage(newTask)),"taskSendNotification-out-0");
        sendCommunication(new TaskCreateReportEvent(dto.getUserId(), dto.getPoints()), "taskCreateReport-out-0");
        return newTask;
    }

    public void addTag(UUID taskId, UUID tagId) {
        Task task = repository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found"));
        Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new NotFoundException("Tag not found"));
        task.getTags().add(tag);
        repository.save(task);
    }

    public TaskDto update(TaskDto dto) {
        Task task = repository.findById(dto.getId()).orElseThrow(() -> new NotFoundException("Task not found"));
        updateEntity(dto, task);
        TaskDto newTask = mapToDto(repository.save(task));
        sendCommunication(new TaskSendNotificationEvent(dto.getUserId(), dto.getTitle(), dto.getTargetDate(), updateMessage(newTask)),"taskSendNotification-out-0");
        return newTask;
    }

    public void delete(UUID id) {
        Task task = repository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        repository.delete(task);
        TaskDto dto = mapToDto(task);
        sendCommunication(new TaskSendNotificationEvent(dto.getUserId(), dto.getTitle(), dto.getTargetDate(), deleteMessage(dto)),"taskSendNotification-out-0");
    }


    private void sendCommunication(IEvent event, String bindName) {
        streamBridge.send(bindName, event);
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

