package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
