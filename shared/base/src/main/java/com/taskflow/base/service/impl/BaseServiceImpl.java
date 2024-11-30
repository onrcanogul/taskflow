package com.taskflow.base.service.impl;

import com.taskflow.base.dto.BaseDto;
import com.taskflow.base.entity.BaseEntity;
import com.taskflow.base.repository.BaseRepository;
import com.taskflow.base.service.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDto> implements BaseService<T, D> {
    private final BaseRepository<T> repository;
    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public List<D> get(int page , int size, Optional<Predicate<? super T>> predicate) {
        Stream<T> entityStream = repository.findAll().stream();
        if(predicate != null) {
             entityStream = entityStream.filter(predicate.get());
        }
        if(page != 0 && size != 0) {
             entityStream = entityStream.skip((long) page * size).limit(size);
        }
        return entityStream.map(this::mapToDto).collect(Collectors.toList());
    }

    public D getSingle(Predicate<T> predicate) {
        T entity = repository.findAll().stream().filter(predicate)
                .findFirst().orElseThrow(RuntimeException::new);
        return mapToDto(entity);
    }

    public D create(D dto) {
        T entity = mapToEntity(dto);
        T newEntity = repository.save(entity);
        return mapToDto(newEntity);
    }

    public D update(D dto, UUID id) {
        T entity = repository.findById(id).orElseThrow(RuntimeException::new);
        updateEntity(dto, entity);
        repository.save(entity);
        return dto;
    }

    public void delete(UUID id) {
        T entity = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(entity);
    }


    protected abstract void updateEntity(D dto, T entity);
    protected abstract D mapToDto(T entity);
    protected abstract T mapToEntity(D dto);

}
