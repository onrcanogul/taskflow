package com.taskflow.task.repository;

import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.task.entity.Tag;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends BaseRepository<Tag> {
}