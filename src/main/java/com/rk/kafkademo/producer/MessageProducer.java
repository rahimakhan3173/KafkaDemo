package com.rk.kafkademo.producer;

import com.rk.kafkademo.config.KafkaTopicConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String key, String message) {
        kafkaTemplate.send(KafkaTopicConfig.TOPIC, key, message);
    }
}