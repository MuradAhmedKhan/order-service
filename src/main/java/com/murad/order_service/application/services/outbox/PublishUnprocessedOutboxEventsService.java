package com.murad.order_service.application.services.outbox;

import java.util.List;

import org.springframework.stereotype.Service;

import com.murad.order_service.domain.entity.OutboxEvent;
import com.murad.order_service.domain.kafka.interfaces.IKafkaEventProducer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublishUnprocessedOutboxEventsService {
    private final IKafkaEventProducer iKafkaEventProducer;
    private final GetUnprocessedOutboxEventsService getUnprocessedOutboxEventsService;

    public void processOutboxEvents(){

        List<OutboxEvent> outboxEvents = getUnprocessedOutboxEventsService.getUnprocessedEvents();

        for (OutboxEvent outboxEvent : outboxEvents)
            iKafkaEventProducer.publish("order-events", outboxEvent.getPayload());
    }
}