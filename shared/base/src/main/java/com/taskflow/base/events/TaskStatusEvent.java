package com.taskflow.base.events;

import com.taskflow.base.enums.TaskStatus;
import com.taskflow.base.events.base.IEvent;

import java.util.UUID;

public class TaskStatusEvent implements IEvent {
    private UUID userId;
    private TaskStatus status;
    private int points;

    public TaskStatusEvent(UUID userId, TaskStatus status, int points) {
        this.status = status;
        this.userId = userId;
        this.points = points;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
