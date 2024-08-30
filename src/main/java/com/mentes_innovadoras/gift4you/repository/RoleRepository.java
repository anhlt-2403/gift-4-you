package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
