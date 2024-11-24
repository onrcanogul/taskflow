package com.taskflow.shared.service;

import com.taskflow.shared.dto.BaseDto;
import com.taskflow.shared.entity.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface BaseService<T extends BaseEntity, D extends BaseDto> {
    public List<D> get(int page, int size, Optional<Predicate<? super T>> predicate);
    public D getSingle(Predicate<? super BaseEntity> predicate);
    public D create(D dto);
    public D update(D dto);
        public void delete(UUID id);
}
