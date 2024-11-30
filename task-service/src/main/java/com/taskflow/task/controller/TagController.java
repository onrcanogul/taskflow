package com.taskflow.task.controller;

import com.taskflow.task.dto.TagDto;
import com.taskflow.task.service.TagService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tag")
@AllArgsConstructor
public class TagController {
    private TagService service;

    @GetMapping
    public ResponseEntity<List<TagDto>> get(@RequestParam int page, @RequestParam int size){
        return ResponseEntity.ok(service.get(page, size, null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> get(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getSingle(e -> e.getId() == id));
    }

    @PostMapping
    public ResponseEntity<TagDto> create(@RequestBody TagDto dto) {
        return ResponseEntity.status(201).body(service.create(dto));
    }

    @PutMapping
    public ResponseEntity<TagDto> update(@RequestBody TagDto dto) {
        return ResponseEntity.status(200).body(service.update(dto, dto.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(204).build();
    }
}
