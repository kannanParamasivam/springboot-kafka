package com.springboot.kafka.producerconsumer.consumer;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@KafkaListener(topics = "products", groupId = "class-consumer")
public class ClassListener {

    @KafkaHandler
    void stringConsumer(String message) {
        System.out.println(MessageFormat.format("ClassListener: String -> {0}",message));
    }

}
