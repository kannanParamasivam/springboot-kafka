package com.springboot.kafka.producerconsumer.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic productsTopic() {
        return TopicBuilder
                .name("products")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic transactionTopic() {
        return TopicBuilder
                .name("transactions")
                .partitions(1)
                .replicas(1)
                .build();
    }

}
