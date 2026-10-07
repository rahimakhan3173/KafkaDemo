package com.rk.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeadLetterConsumer {

    @KafkaListener(topics = "demo-topic-dlt", groupId = "dlt-group")
    public void handleDead(String message) {
        System.out.println("DEAD LETTER: " + message);
    }
}