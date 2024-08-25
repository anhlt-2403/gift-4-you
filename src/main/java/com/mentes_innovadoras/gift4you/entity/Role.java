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
@Table(name = "\"Role\"")
public class Role {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Description")
    private String description;

}