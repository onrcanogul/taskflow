package com.taskflow.shared.repository;

import com.taskflow.shared.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseRepository<D extends BaseEntity> extends JpaRepository<D, UUID> {
}
