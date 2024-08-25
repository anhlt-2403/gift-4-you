package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"OrderHistory\"")
public class OrderHistory {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OrderId", nullable = false)
    private Order order;

    @Column(name = "Status", nullable = false, length = 10)
    private String status;

    @Column(name = "CreateAt")
    private Instant createAt;

    @Column(name = "UpdateAt")
    private Instant updateAt;

    @Column(name = "Description")
    private String description;

}