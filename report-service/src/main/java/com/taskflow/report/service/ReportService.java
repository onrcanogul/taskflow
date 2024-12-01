package com.taskflow.report.service;

import com.taskflow.base.enums.TaskStatus;
import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.entity.Report;
import com.taskflow.base.service.BaseService;

public interface ReportService extends BaseService<Report, ReportDto> {
    void handleCreatedTask(Report report);
    void handleChangeTaskStatus(Report report, TaskStatus status, int points);
}
