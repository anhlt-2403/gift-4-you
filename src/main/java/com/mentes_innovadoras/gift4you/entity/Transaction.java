package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"transaction\"")
public class Transaction {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Size(max = 20)
    @Nationalized
    @Column(name = "payment_method", length = 20)
    private String paymentMethod;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 18)
    private BigDecimal amount;

    @Column(name = "create_at")
    private Instant createAt;

    @Size(max = 20)
    @Nationalized
    @Column(name = "status", length = 20)
    private String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}