package com.mentes_innovadoras.gift4you.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "template")
public class Template {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Lob
    @Column(name = "url_img", nullable = false)
    private String urlImg;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

    @Column(name = "price", precision = 18)
    private BigDecimal price;

    @Column(name = "total_sales")
    private Integer totalSales;

    @OneToMany(mappedBy = "template")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "template")
    private Set<TemplateDetail> templateDetails = new LinkedHashSet<>();

}