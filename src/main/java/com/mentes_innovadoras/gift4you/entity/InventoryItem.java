package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "inventory_item")
public class InventoryItem {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "create_at")
    private Instant createAt;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false, precision = 18)
    private BigDecimal price;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @NotNull
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "update_at")
    private Instant updateAt;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @OneToMany(mappedBy = "inventoryItem")
    private Set<OrderDetailItem> orderDetailItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "inventoryItem")
    private Set<TemplateDetail> templateDetails = new LinkedHashSet<>();

}