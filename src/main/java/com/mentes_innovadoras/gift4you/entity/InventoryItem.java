package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"InventoryItem\"")
public class InventoryItem {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price", nullable = false, precision = 18)
    private BigDecimal price;

    @Column(name = "Stock", nullable = false)
    private Integer stock;

    @Column(name = "Status", nullable = false, length = 20)
    private String status;

    @Column(name = "CreateAt")
    private Instant createAt;

    @Column(name = "UpdateAt")
    private Instant updateAt;

}