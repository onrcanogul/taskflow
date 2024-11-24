package com.taskflow.task_service.repository;

import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.task_service.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepository<Task> {
}
