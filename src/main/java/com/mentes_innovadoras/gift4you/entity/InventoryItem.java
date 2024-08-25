package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class InventoryItem {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column
    private String description;

    @Column(nullable = false, precision = 18)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false, length = 20)
    private String status;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Provider provider;
}