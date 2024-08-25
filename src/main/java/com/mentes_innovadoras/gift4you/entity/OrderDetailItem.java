package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderDetailItem {
    @Id
    @Column(nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private OrderDetail orderDetail;

    @ManyToOne
    @JoinColumn(nullable = false)
    private InventoryItem inventoryItem;

    @Column(nullable = false)
    private Integer quantity;

}