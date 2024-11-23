package com.taskflow.task_service.entity;


import com.taskflow.shared.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Tag extends BaseEntity {
    private String name;
//    List<Task> tasks;
}
