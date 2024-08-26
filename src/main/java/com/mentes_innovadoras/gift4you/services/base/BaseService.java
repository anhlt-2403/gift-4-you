package com.mentes_innovadoras.gift4you.services.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BaseService<T> {
    T save(T entity);
    void delete(UUID id);
}