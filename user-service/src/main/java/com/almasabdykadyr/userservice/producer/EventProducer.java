package com.almasabdykadyr.userservice.producer;

import com.almasabdykadyr.userservice.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//TODO: make more representative events

@Service
@RequiredArgsConstructor
public class EventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendEvent(User user) {

        try {
            String payload = objectMapper.writeValueAsString(user);
            kafkaTemplate.send("user.events", payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
