package com.murad.order_service.infrastructure.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.murad.order_service.domain.kafka.interfaces.IKafkaEventProducer;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaEventProducer implements IKafkaEventProducer{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publish(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }
}