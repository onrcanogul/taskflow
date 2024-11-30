package com.taskflow.task.entity;


import com.taskflow.base.entity.BaseEntity;
import com.taskflow.task.enums.TaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Task extends BaseEntity {
    private String title;
    private String description;
    private UUID userId;
    private LocalDateTime targetDate;
    private int points;
    private TaskStatus status;

    @ManyToMany(targetEntity = Tag.class)
    private List<Tag> tags;
}
