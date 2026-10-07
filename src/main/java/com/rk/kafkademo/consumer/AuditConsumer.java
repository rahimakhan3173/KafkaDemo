package com.rk.kafkademo.consumer;

import com.rk.kafkademo.config.KafkaTopicConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AuditConsumer {

    @KafkaListener(topics = KafkaTopicConfig.TOPIC, groupId = "audit-group")
    public void audit(String message) {
        System.out.println("AUDIT saw: " + message);
    }
}