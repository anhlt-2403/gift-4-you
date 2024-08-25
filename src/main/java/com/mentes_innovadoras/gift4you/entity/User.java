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
@Table(name = "\"User\"")
public class User {
    @Id
    @Column(name = "Id", nullable = false)
    private UUID id;

    @Nationalized
    @Column(name = "FullName", length = 50)
    private String fullName;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Status", nullable = false, length = 10)
    private String status;

    @Column(name = "Gender", length = 10)
    private String gender;

    @Column(name = "CreateAt")
    private Instant createAt;

    @Column(name = "UpdateAt")
    private Instant updateAt;

    @Lob
    @Column(name = "UrlImg")
    private String urlImg;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "UserName", length = 20)
    private String userName;

    @Lob
    @Column(name = "Password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RoleId", nullable = false)
    private Role role;

}