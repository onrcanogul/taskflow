package com.taskflow.shared.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(updatable = false, name = "created_at")
    @CreatedDate
    private LocalDateTime createdDate;
    @Column(updatable = false, name = "created_by")
    @CreatedBy
    private String createdBy;
    @Column(insertable = false, name = "updated_at")
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @Column(insertable = false, name = "updated_by")
    @LastModifiedBy
    private String updatedBy;

}
