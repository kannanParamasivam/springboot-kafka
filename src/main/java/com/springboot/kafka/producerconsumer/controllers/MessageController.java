package com.springboot.kafka.producerconsumer.controllers;

import com.springboot.kafka.producerconsumer.modals.Product;
import com.springboot.kafka.producerconsumer.producer.ProductProducer;
import com.springboot.kafka.producerconsumer.producer.StringProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/produce")
public class MessageController {

    private StringProducer stringProducer;
    private ProductProducer productProducer;
    private int key;

    @Autowired
    public MessageController(StringProducer stringProducer, ProductProducer productProducer) {
        this.stringProducer = stringProducer;
        this.productProducer = productProducer;
        this.key = 1;
    }

    @PostMapping
    @RequestMapping("string/{topic}/{message}")
    public String produceString(@PathVariable("topic") String topic, @PathVariable("message") String message) {
        String res = this.stringProducer.sendMessage(topic,
                String.valueOf(this.key),
                message);
        key += 1;
        return res;
    }

    @PostMapping
    @RequestMapping("product/{topic}")
    public String produce(@PathVariable("topic") String topic, @RequestBody Product message) {
        String res = this.productProducer.sendMessage(topic,
                String.valueOf(this.key),
                message);
        key += 1;
        return res;
    }
}
