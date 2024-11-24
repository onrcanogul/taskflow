package com.taskflow.shared.repository;

import com.taskflow.shared.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<D extends BaseEntity> extends JpaRepository<D, UUID> {
}
