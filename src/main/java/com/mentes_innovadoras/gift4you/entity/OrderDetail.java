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
public class OrderDetail {
    @Id
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Orders order;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 18)
    private BigDecimal price;

    @Column
    private String description;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

}