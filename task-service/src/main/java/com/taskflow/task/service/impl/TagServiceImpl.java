package com.taskflow.task.service.impl;


import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.task.dto.TagDto;
import com.taskflow.task.entity.Tag;
import com.taskflow.task.repository.TagRepository;
import com.taskflow.task.service.TagService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, TagDto> implements TagService {
    public TagServiceImpl(TagRepository repository, StreamBridge streamBridge) {
        super(repository, streamBridge);
    }
    @Override
    protected void updateEntity(TagDto dto, Tag entity) {
        entity.setName(dto.getName());
        entity.setTasks(dto.getTasks());
    }

    @Override
    protected TagDto mapToDto(Tag entity) {
        TagDto dto = new TagDto();
        dto.setName(entity.getName());
        dto.setTasks(entity.getTasks());
        return dto;
    }

    @Override
    protected Tag mapToEntity(TagDto dto) {
        Tag tag = new Tag();
        tag.setTasks(dto.getTasks());
        tag.setName(dto.getName());
        return tag;
    }
}
