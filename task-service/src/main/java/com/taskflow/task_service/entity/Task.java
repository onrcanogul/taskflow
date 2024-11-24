package com.taskflow.task_service.entity;


import com.taskflow.shared.entity.BaseEntity;
import com.taskflow.task_service.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Task extends BaseEntity {
    private String title;
    private String description;
    private String userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;

    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;
}
