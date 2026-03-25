package com.murad.order_service.domain.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderResponse(
    Long id,
    String orderNumber,
    Long userId,
    BigDecimal totalAmount,
    String status,
    Instant createdAt,
    Instant updatedAt
) {}