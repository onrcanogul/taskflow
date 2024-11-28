package com.taskflow.base.service;


import com.taskflow.base.dto.BaseDto;
import com.taskflow.base.entity.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

public interface BaseService<T extends BaseEntity, D extends BaseDto> {
    public List<D> get(int page, int size, Optional<Predicate<? super T>> predicate);
    public D getSingle(Predicate<T> predicate);
    public D create(D dto);
    public D update(D dto, UUID id);
    public void delete(UUID id);
}
