package com.mentes_innovadoras.gift4you.payload.reponse.review;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Setter;

import java.util.UUID;

@Setter
public class ReviewResponse {
    private String description;

    private Integer start;
}
