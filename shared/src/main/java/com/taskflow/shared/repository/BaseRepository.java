package com.taskflow.shared.repository;

import com.taskflow.shared.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<D extends BaseEntity> extends JpaRepository<BaseEntity, Long> {
}
