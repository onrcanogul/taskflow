package com.taskflow.base.events;

import com.taskflow.base.events.base.IEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter @Setter @ToString
@AllArgsConstructor
public class TaskCreateReportEvent implements IEvent {
    private UUID userId;
    private int points;
}
