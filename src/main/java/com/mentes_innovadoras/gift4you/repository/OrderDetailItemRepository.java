package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.OrderDetailItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailItemRepository extends JpaRepository<OrderDetailItem, UUID> {
}
