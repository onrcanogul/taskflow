package com.taskflow.task_service.controller;

import com.taskflow.task_service.dto.TaskDto;
import com.taskflow.task_service.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskDto>> get(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(service.get(page, size, null));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getSingle(e -> e.getId() == id));
    }

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto dto) {
        return ResponseEntity.status(200).body(service.update(dto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }

}
