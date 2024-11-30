package com.taskflow.task.controller;

import com.taskflow.task.dto.TaskDto;
import com.taskflow.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskDto>> get(@RequestParam(name="page") String page, @RequestParam(name = "size") String size){
        return ResponseEntity.ok(service.get(Integer.parseInt(page), Integer.parseInt(size), null));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getSingle(e -> e.getId() == id));
    }

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PostMapping("/tag")
    public ResponseEntity<Void> addTag(@RequestBody UUID taskId, @RequestBody UUID tagId) {
        service.addTag(taskId, tagId);
        return ResponseEntity.status(204).build();
    }

    @PutMapping
    public ResponseEntity<TaskDto> update(@RequestBody TaskDto dto) {
        return ResponseEntity.status(200).body(service.update(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") UUID id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }

}
