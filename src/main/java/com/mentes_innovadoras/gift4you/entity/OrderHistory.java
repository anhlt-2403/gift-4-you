package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order_history")
public class OrderHistory {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "create_at")
    private OffsetDateTime createAt;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Size(max = 10)
    @NotNull
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "update_at")
    private OffsetDateTime updateAt;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}