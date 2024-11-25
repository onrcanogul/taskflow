package com.taskflow.report.controller;

import com.taskflow.report.dto.ReportDto;
import com.taskflow.report.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportController {
    private final ReportService service;

    @GetMapping("/{userId}")
    public ResponseEntity<ReportDto> get(@PathVariable UUID userId) {
        return ResponseEntity.status(200).body(service.getSingle(r -> r.getUserId() == userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable UUID userId) {
        service.delete(userId);
        return ResponseEntity.status(204).build();
    }

}
