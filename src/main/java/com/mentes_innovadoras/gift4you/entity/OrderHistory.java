package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class OrderHistory {
    @Id
    @Column(nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Order order;

    @Column(nullable = false, length = 10)
    private String status;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

    @Column
    private String description;

}