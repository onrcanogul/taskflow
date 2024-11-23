package com.taskflow.task_service.service.impl;

import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.shared.service.impl.BaseServiceImpl;
import com.taskflow.task_service.dto.TagDto;
import com.taskflow.task_service.entity.Tag;
import com.taskflow.task_service.service.TagService;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl extends BaseServiceImpl<Tag, TagDto> implements TagService {
    public TagServiceImpl(BaseRepository<Tag> repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(TagDto dto, Tag entity) {

    }

    @Override
    protected TagDto mapToDto(Tag entity) {
        return null;
    }

    @Override
    protected Tag mapToEntity(TagDto dto) {
        return null;
    }
}
