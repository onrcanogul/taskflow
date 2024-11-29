package com.taskflow.user.entity;

import com.taskflow.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class User extends BaseEntity {
    private String username;
    private String email;
    private int level;
    private int points;
}
