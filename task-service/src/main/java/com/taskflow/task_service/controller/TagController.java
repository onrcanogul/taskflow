package com.taskflow.task_service.controller;

import com.taskflow.task_service.dto.TagDto;
import com.taskflow.task_service.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@AllArgsConstructor
public class TagController {
    private TagService service;

    @GetMapping
    public ResponseEntity<List<TagDto>> get(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(service.get(page, size, null));
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> get(@PathVariable long id) {
        return ResponseEntity.ok(service.getSingle(e -> e.getId() == id));
    }

    @PostMapping
    public ResponseEntity<TagDto> create(@RequestBody TagDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<TagDto> update(@RequestBody TagDto dto) {
        return ResponseEntity.status(200).body(service.update(dto));
    }

    @DeleteMapping("/{tagId}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}
