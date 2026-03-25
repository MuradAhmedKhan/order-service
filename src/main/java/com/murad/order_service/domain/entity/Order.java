package com.murad.order_service.domain.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID orderNumber;
    private Long userId;
    private BigDecimal totalAmount;
    private String status;
    private Instant createdAt;

    @Version
    private Long version;
}