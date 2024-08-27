package com.mentes_innovadoras.gift4you.services.base;
import com.mentes_innovadoras.gift4you.repository.generic.GenericRepository;


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
            throw e;
        }
    }

    @Override
    public void delete(UUID id)  {
        try {
            genericRepository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
