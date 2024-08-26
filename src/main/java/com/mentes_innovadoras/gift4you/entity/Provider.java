package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Provider {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String contactInfo;

    @Column
    private String address;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

    @Column(nullable = false, length = 20)
    private String status;

}