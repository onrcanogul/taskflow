package com.taskflow.task_service.entity;


import com.taskflow.shared.entity.BaseEntity;
import com.taskflow.task_service.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Task extends BaseEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String tags;
    private String userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;
}
