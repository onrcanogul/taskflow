package com.taskflow.report.service.client;

import com.taskflow.report.dto.client.TaskDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "tasks")
public interface TaskFeignClient {
    @GetMapping("/completed/{userId}")
    public ResponseEntity<List<TaskDto>> getCompleted(@PathVariable UUID userId);
}
