package com.taskflow.base.repository;

import com.taskflow.base.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
}
