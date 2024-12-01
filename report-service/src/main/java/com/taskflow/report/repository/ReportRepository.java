package com.taskflow.report.repository;

import com.taskflow.report.entity.Report;
import com.taskflow.base.repository.BaseRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReportRepository extends BaseRepository<Report> {
    Optional<Report> findByUserId(UUID userId);
}
