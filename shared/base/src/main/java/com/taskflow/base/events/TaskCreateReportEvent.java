package com.taskflow.base.events;

import com.taskflow.base.events.base.IEvent;

import java.util.UUID;


public class TaskCreateReportEvent implements IEvent {
    private UUID userId;
    private int points;

    public TaskCreateReportEvent() {
    }
    public TaskCreateReportEvent(UUID userId, int points) {
        this.points = points;
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
