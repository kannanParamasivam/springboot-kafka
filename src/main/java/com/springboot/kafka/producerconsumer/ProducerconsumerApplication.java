package com.springboot.kafka.producerconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.StreamHandler;
import java.util.stream.Stream;

@SpringBootApplication
public class ProducerconsumerApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext appContext = SpringApplication.run(ProducerconsumerApplication.class, args);
		// List the beans registered with application Context
		// Stream.of(appContext.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
