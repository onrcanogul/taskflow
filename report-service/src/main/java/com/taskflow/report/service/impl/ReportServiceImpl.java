package com.taskflow.report.service.impl;

import com.taskflow.base.enums.TaskStatus;
import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.entity.Report;
import com.taskflow.report.repository.ReportRepository;
import com.taskflow.report.service.ReportService;
import com.taskflow.base.service.impl.BaseServiceImpl;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends BaseServiceImpl<Report, ReportDto> implements ReportService {
    private final ReportRepository repository;
    public ReportServiceImpl(ReportRepository repository, StreamBridge streamBridge) {
        super(repository, streamBridge);
        this.repository = repository;
    }

    @Override
    public void handleCreatedTask(Report report) {
        report.setCompletedTasks(report.getCompletedTasks() + 1);
        report.setActiveTasks(report.getActiveTasks() - 1);
        repository.save(report);
    }

    @Override
    public void handleChangeTaskStatus(Report report, TaskStatus status, int points) {
        if(status == TaskStatus.Done) {
            report.setCompletedTasks(report.getCompletedTasks() + 1);
            report.setActiveTasks(report.getActiveTasks() - 1);
            report.setPoints(report.getPoints() + points);
            repository.save(report);
        }
    }

    @Override
    protected void updateEntity(ReportDto dto, Report entity) {
        entity.setActiveTasks(dto.getActiveTasks());
        entity.setLevel(dto.getLevel());
        entity.setCompletedTasks(dto.getCompletedTasks());
        entity.setUserId(dto.getUserId());
        entity.setPoints(dto.getPoints());
    }

    @Override
    protected ReportDto mapToDto(Report entity) {
        ReportDto dto = new ReportDto();
        dto.setId(entity.getId());
        dto.setActiveTasks(entity.getActiveTasks());
        dto.setLevel(entity.getLevel());
        dto.setPoints(entity.getPoints());
        dto.setCompletedTasks(entity.getCompletedTasks());
        dto.setUserId(entity.getUserId());
        dto.setCreatedAt(entity.getCreatedDate());
        dto.setUpdatedAt(entity.getUpdatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedBy(entity.getUpdatedBy());
        return dto;
    }

    @Override
    protected Report mapToEntity(ReportDto dto) {
        Report entity = new Report();
        entity.setId(dto.getId());
        entity.setActiveTasks(dto.getActiveTasks());
        entity.setLevel(dto.getLevel());
        entity.setPoints(dto.getPoints());
        entity.setCompletedTasks(dto.getCompletedTasks());
        entity.setUserId(dto.getUserId());
        entity.setCreatedDate(dto.getCreatedAt());
        entity.setCreatedDate(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedBy(dto.getUpdatedBy());

        return entity;
    }


}
