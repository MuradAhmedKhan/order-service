package com.murad.order_service.domain.kafka.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface IKafkaEventProducer {
    void publish(String topic, String payload);
}