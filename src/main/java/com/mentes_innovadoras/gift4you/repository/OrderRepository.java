package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
