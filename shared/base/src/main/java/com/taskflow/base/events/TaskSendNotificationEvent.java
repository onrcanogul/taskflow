package com.taskflow.base.events;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class TaskSendNotificationEvent {
    private UUID userId;
    private String title;
    private LocalDateTime targetDate;
    private String message;
}
