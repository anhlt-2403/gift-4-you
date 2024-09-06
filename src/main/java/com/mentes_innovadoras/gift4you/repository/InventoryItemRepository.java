package com.mentes_innovadoras.gift4you.repository;

import com.mentes_innovadoras.gift4you.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {
}
