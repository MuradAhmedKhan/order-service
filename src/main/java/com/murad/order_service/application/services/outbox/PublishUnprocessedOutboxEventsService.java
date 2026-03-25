package com.murad.order_service.application.services.outbox;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.murad.order_service.domain.entity.OutboxEvent;
import com.murad.order_service.domain.kafka.interfaces.IKafkaEventProducer;
import com.murad.order_service.domain.repository.OutboxRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublishUnprocessedOutboxEventsService {
    private final OutboxRepository outboxRepository;
    private final IKafkaEventProducer iKafkaEventProducer;

    @Transactional(readOnly = true)
    public void processOutboxEvents(){
        List<OutboxEvent> events = outboxRepository.findUnprocessedEvents();

        for (OutboxEvent outboxEvent : events)
            iKafkaEventProducer.publish("order-events", outboxEvent.getPayload());
    }
}