package com.murad.order_service.infrastructure.scheduler.outbox;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.murad.order_service.application.services.outbox.PublishUnprocessedOutboxEventsService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OutboxSchedular {
    private final PublishUnprocessedOutboxEventsService outboxProcessorService;

    @Scheduled(fixedDelay = 5000)
    public void run(){
        outboxProcessorService.processOutboxEvents();
    }
}