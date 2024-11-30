package com.taskflow.base.events;

import com.taskflow.base.events.base.IEvent;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaskSendNotificationEvent implements IEvent {
    private UUID userId;
    private String title;
    private LocalDateTime targetDate;
    private String message;

    public TaskSendNotificationEvent() {
    }

    public TaskSendNotificationEvent(UUID userId, String title, LocalDateTime targetDate, String message) {
        this.message = message;
        this.targetDate = targetDate;
        this.title = title;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
