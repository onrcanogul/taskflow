package com.taskflow.task.repository;

import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.task.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepository<Task> {
}
