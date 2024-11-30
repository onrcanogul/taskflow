package com.taskflow.base.events;

import com.taskflow.base.events.base.IEvent;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @ToString
@AllArgsConstructor
public class TaskSendNotificationEvent implements IEvent {
    private UUID userId;
    private String title;
    private LocalDateTime targetDate;
    private String message;
}
