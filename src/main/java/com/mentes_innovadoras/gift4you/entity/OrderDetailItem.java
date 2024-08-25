package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"OrderDetailItem\"")
public class OrderDetailItem {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

}