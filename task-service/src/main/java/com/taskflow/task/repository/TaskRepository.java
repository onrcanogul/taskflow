package com.taskflow.task.repository;

import com.taskflow.base.enums.TaskStatus;
import com.taskflow.base.repository.BaseRepository;
import com.taskflow.task.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends BaseRepository<Task> {
    List<Task> findByUserIdAndStatus(UUID userId, TaskStatus status);
}
