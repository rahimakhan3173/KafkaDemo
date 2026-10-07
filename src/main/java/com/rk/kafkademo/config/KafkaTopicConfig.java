package com.rk.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC = "demo-topic";

    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder.name(TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic demoDltTopic() {
        return TopicBuilder.name(TOPIC + "-dlt")
                .partitions(3)
                .replicas(1)
                .build();
    }
}