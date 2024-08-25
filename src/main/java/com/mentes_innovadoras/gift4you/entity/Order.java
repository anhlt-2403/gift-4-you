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
@Table(name = "\"Order\"")
public class Order {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Status", nullable = false, length = 10)
    private String status;

    @Column(name = "TotalPrice", nullable = false, precision = 18)
    private BigDecimal totalPrice;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "PhoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "CreateAt")
    private Instant createAt;

    @Column(name = "UpdateAt")
    private Instant updateAt;

    @Column(name = "Description")
    private String description;

}