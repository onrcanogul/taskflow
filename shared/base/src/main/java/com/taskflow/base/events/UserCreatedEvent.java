package com.taskflow.base.events;

import com.taskflow.base.events.base.IEvent;

import java.util.UUID;

public class UserCreatedEvent implements IEvent {
    private UUID userId;
    public UserCreatedEvent(UUID userId) {
        this.userId = userId;
    }
    public UUID getUserId() {
        return userId;
    }
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
