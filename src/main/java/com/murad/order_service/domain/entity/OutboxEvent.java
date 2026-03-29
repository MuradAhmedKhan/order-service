package com.murad.order_service.domain.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "outbox_events")
public class OutboxEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aggregate_type")
    private String aggregateType;

    @Column(name = "aggregate_id")
    private String aggregateId;

    @Lob
    private String payload;

    private String eventStatus;

    @Column(name = "created_at")
    private Instant createdAt;

    @Version
    private Long version;
}