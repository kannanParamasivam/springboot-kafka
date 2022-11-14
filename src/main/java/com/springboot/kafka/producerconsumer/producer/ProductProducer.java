package com.springboot.kafka.producerconsumer.producer;

import com.springboot.kafka.producerconsumer.modals.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.text.MessageFormat;

@Component
public class ProductProducer {
    private final KafkaTemplate<String, Product> kafkaTemplate;

    @Autowired
    public ProductProducer(KafkaTemplate<String, Product> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String topic, String key, Product value) {
        ListenableFuture<SendResult<String, Product>> future = this.kafkaTemplate.send(topic, key, value);

        future.addCallback(result -> {
            assert result != null;
            System.out.println(MessageFormat.format("""
                            Message persisted.
                            Topic:{0}
                            Key:{1}
                            Partition:{2}
                            Offset:{3}""",
                    result.getRecordMetadata().topic(),
                    result.getProducerRecord().key(),
                    result.getRecordMetadata().partition(),
                    result.getRecordMetadata().offset()));
        }, ex -> {
            System.out.println(MessageFormat.format("""
                            Message could not be persisted.
                            Topic:{0}
                            Key:{1}""",
                    topic, "key"));
        });

        return "Published!";
    }
}
