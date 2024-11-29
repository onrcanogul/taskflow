package com.taskflow.task.service.impl;

import com.taskflow.base.repository.BaseRepository;
import com.taskflow.base.service.impl.BaseServiceImpl;
import com.taskflow.task.dto.TagDto;
import com.taskflow.task.entity.Tag;
import com.taskflow.task.service.TagService;
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
