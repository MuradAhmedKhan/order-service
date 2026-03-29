package com.murad.order_service.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest(
    @NotNull
    Long userId,
    
    @Positive
    BigDecimal totalAmount
) {}