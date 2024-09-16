package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @Size(max = 50)
    @NotNull
    @Column(name = "contact_info", nullable = false, length = 50)
    private String contactInfo;

    @Column(name = "create_at")
    private Instant createAt;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "update_at")
    private Instant updateAt;

    @OneToMany(mappedBy = "provider")
    private Set<InventoryItem> inventoryItems = new LinkedHashSet<>();

}