package com.rk.kafkademo.consumer;

import com.rk.kafkademo.config.KafkaTopicConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = KafkaTopicConfig.TOPIC)
    public void listen(ConsumerRecord<String, String> record) {
        System.out.printf("Received key=%s value=%s partition=%d offset=%d%n",
                record.key(), record.value(), record.partition(), record.offset());
    }
}