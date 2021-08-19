package com.minejava.basicspringbootkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BasicSpringbootKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicSpringbootKafkaApplication.class, args);
	}
}
