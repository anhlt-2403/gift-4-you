package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account{
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "create_at")
    private Date createAt;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 50)
    @Nationalized
    @Column(name = "full_name", length = 50)
    private String fullName;

    @Size(max = 10)
    @Column(name = "gender", length = 10)
    private String gender;

    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 20)
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Size(max = 10)
    @NotNull
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    @Column(name = "update_at")
    private Date updateAt;

    @Lob
    @Column(name = "url_img")
    private String urlImg;

    @Size(max = 20)
    @Column(name = "user_name", nullable = false, length = 20)
    private String userName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "account")
    private Set<Order> orders = new LinkedHashSet<>();
}