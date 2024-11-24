package com.taskflow.task.entity;

import com.taskflow.shared.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Tag extends BaseEntity {
    private String name;

    @ManyToMany(targetEntity = Task.class)
    private List<Task> tasks;
}
