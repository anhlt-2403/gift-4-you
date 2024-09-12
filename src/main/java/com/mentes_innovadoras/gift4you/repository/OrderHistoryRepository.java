package com.mentes_innovadoras.gift4you.repository;


import com.mentes_innovadoras.gift4you.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, UUID> {
}
