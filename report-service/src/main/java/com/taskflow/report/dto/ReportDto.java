package com.taskflow.report.dto;

import com.taskflow.report.enums.ReportType;
import com.taskflow.shared.dto.BaseDto;
import lombok.Data;

import java.util.UUID;

@Data
public class ReportDto extends BaseDto {
    private UUID userId;
    private int completedTasks;
    private int activeTasks;
    private int level;
    private int points;
    private ReportType reportType;
}
