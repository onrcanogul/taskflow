package com.taskflow.notification.entity;

import com.taskflow.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Notification extends BaseEntity {
    private String to;
    private String subject;
    private String content;
}
