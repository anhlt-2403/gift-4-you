package com.mentes_innovadoras.gift4you.services.base;

import com.mentes_innovadoras.gift4you.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.UUID;


public  class BaseServiceImpl<T> implements BaseService<T> {

    protected final GenericRepository<T> genericRepository;

    public BaseServiceImpl(GenericRepository<T> genericRepository) {
        this.genericRepository = genericRepository;
    }


    @Override
    public T save(T entity) {
        try {
            return genericRepository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save entity", e);
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete entity with id " + id, e);
        }
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        try {
            return genericRepository.findAll(pageable);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve entities", e);
        }
    }

    @Override
    public Optional<T> findById(UUID id) {
        try {
            return genericRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find entity with id " + id, e);
        }
    }
}
