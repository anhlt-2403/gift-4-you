package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.User;
import com.mentes_innovadoras.gift4you.repository.generic.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends GenericRepository<User> {
    Page<User> findByFullNameContaining(String fullName, Pageable pageable);
}
