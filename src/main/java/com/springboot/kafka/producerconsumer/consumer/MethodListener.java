package com.springboot.kafka.producerconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

@Component
public class MethodListener {

    @KafkaListener(topics = "products", groupId = "myconsumer")
    void productListener(String data) throws InterruptedException {
        System.out.println(MessageFormat.format("Message consumed -> {0}", data));
    }

    @KafkaListener(topics = {"products", "transactions"}, groupId = "multitopicConsumer")
    void productAndTransactionListener(String data) {
        System.out.println(MessageFormat.format("Multi topic consumer consumed: -> {0}", data));
    }
}
