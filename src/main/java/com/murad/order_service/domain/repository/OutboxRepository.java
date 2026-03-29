package com.murad.order_service.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.murad.order_service.domain.entity.OutboxEvent;

@Repository
public interface OutboxRepository extends JpaRepository<OutboxEvent, Long> {
    Page<OutboxEvent> findByEventStatus(String eventStatus, Pageable pageable);
}