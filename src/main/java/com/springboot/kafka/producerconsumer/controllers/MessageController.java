package com.springboot.kafka.producerconsumer.controllers;

import com.springboot.kafka.producerconsumer.producer.StringProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/produce")
public class MessageController {

    private StringProducer producer;
    private int key;

    @Autowired
    public MessageController(StringProducer producer) {
        this.producer = producer;
        this.key = 1;
    }

    @PostMapping
    @RequestMapping("/{topic}/{message}")
    public String produce(@PathVariable("topic") String topic, @PathVariable("message") String m) {
        String res = this.producer.sendMessage(topic,
                String.valueOf(this.key),
                m);
        key += 1;
        return res;
    }
}
