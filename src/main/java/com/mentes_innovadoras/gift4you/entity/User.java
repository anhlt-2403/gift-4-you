package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Nationalized
    @Column(length = 50)
    private String fullName;

    @Column(length = 100)
    private String email;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(length = 10)
    private String gender;

    @Column
    private Instant createAt;

    @Column
    private Instant updateAt;

    @Lob
    @Column
    private String urlImg;

    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 20)
    private String userName;

    @Lob
    @Column
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Role role;

}