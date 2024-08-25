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
public class Order {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, precision = 18)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

    @Column
    private String description;

}