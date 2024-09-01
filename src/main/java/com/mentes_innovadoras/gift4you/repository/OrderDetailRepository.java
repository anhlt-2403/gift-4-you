package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}
