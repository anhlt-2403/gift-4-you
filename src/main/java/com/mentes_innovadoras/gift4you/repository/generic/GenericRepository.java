package com.mentes_innovadoras.gift4you.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;
@NoRepositoryBean
public interface GenericRepository<T> extends JpaRepository<T, UUID> {
}
