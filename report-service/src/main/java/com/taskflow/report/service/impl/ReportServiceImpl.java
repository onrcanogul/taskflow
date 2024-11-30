package com.taskflow.report.service.impl;

import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.entity.Report;
import com.taskflow.report.service.ReportService;
import com.taskflow.base.repository.BaseRepository;
import com.taskflow.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl extends BaseServiceImpl<Report, ReportDto> implements ReportService {
    public ReportServiceImpl(BaseRepository<Report> repository) {
        super(repository);
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
