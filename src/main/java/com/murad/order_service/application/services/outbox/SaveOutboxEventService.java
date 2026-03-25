package com.murad.order_service.application.services.outbox;

import org.springframework.stereotype.Service;

import com.murad.order_service.domain.entity.Order;
import com.murad.order_service.domain.entity.OutboxEvent;
import com.murad.order_service.domain.mapper.outboxMapper.OutboxEventMapper;
import com.murad.order_service.domain.repository.OutboxRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOutboxEventService {

    private final OutboxRepository outboxRepository;
    private final OutboxEventMapper outboxEventMapper;

    @Transactional
    public void saveOutboxEvents(Order order, String payload){
        OutboxEvent outboxEvent = outboxEventMapper.toEntity(order, payload);
        outboxRepository.save(outboxEvent);
    }
}