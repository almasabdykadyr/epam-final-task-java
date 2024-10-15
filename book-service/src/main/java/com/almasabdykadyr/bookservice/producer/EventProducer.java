package com.almasabdykadyr.bookservice.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendNotificationEvent(String id) {

            String payload = String.format("book with id: %s added", id);
            kafkaTemplate.send("book.notifications", payload);
    }
}