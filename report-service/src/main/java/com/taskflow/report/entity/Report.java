package com.taskflow.report.entity;

import com.taskflow.report.enums.ReportType;
import com.taskflow.shared.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Report extends BaseEntity {
    private UUID userId;
    private int completedTasks;
    private int activeTasks;
    private int level;
    private int points;
    private ReportType reportType;
}
