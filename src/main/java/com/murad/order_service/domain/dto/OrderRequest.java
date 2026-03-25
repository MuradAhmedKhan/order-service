package com.murad.order_service.domain.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;

public record OrderRequest(
    @NotBlank Long userId,
    @Positive BigDecimal totalAmount
) {}