package com.taskflow.report.service.client;

import com.taskflow.report.dto.client.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TaskFallback implements TaskFeignClient {
    @Override
    public ResponseEntity<List<TaskDto>> getCompleted(UUID userId) {
        return null;
    }
}
