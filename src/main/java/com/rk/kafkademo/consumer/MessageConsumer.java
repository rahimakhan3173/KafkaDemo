package com.rk.kafkademo.consumer;

import com.rk.kafkademo.config.KafkaTopicConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = KafkaTopicConfig.TOPIC, concurrency = "3")
    public void listen(ConsumerRecord<String, String> record) {
        if (record.value().startsWith("fail")) {
            throw new IllegalStateException("Cannot process: " + record.value());
        }
        System.out.printf("[%s] key=%s value=%s partition=%d offset=%d%n",
                Thread.currentThread().getName(), record.key(), record.value(),
                record.partition(), record.offset());
    }
}