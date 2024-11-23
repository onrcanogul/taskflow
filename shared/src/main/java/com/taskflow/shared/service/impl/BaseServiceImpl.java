package com.taskflow.shared.service.impl;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.shared.entity.BaseEntity;
import com.taskflow.shared.repository.BaseRepository;
import com.taskflow.shared.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;



@Service
@AllArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity, D extends BaseDto> implements BaseService<T, D> {
    private BaseRepository<T> repository;

    public List<D> get(int page, int size, Optional<Predicate<? super T>> predicate) {
        @SuppressWarnings("unchecked")
        Stream<T> entityStream = (Stream<T>) repository.findAll().stream();
        if(page != 0 && size != 0) {
            entityStream.skip((long) page * size).limit(size);
        }
        if(predicate.isPresent()) {
            entityStream.filter(predicate.get());
        }
        return entityStream.map(this::mapToDto).toList();
    }

    public D getSingle(Predicate<? super BaseEntity> predicate) {
        @SuppressWarnings("unchecked")
        T entity = (T)repository.findAll().stream().filter(predicate)
                .findFirst().orElseThrow(RuntimeException::new);
        return mapToDto(entity);
    }

    public D create(D dto) {
        T entity = mapToEntity(dto);
        T newEntity = repository.save(entity);
        return mapToDto(newEntity);
    }

    public D update(D dto) {
        @SuppressWarnings("unchecked")
        T entity = (T)repository.findById(dto.getId()).orElseThrow(RuntimeException::new);
        updateEntity(dto, entity);
        repository.save(entity);
        return dto;
    }

    public void delete(long id) {
        @SuppressWarnings("unchecked")
        T entity = (T)repository.findById(id).orElseThrow(RuntimeException::new);
        repository.delete(entity);
    }


    protected abstract void updateEntity(D dto, T entity);
    protected abstract D mapToDto(T entity);
    protected abstract T mapToEntity(D dto);

}
