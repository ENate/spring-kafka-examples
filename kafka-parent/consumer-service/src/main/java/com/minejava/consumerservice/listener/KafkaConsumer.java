package com.minejava.consumerservice.listener;

import com.minejava.consumerservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    // define how to send messages to consumer and specify topics and groups
    @KafkaListener(topics = "my_first_topic", clientIdPrefix = "group_Id")
    public void consumer(String message) {
        log.info("message consumed: {}", message);
    }

    @KafkaListener(topics = "Kafka_example_json", clientIdPrefix = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumerJson(User user) {
        log.info("Consumed JSON message: {}", user);
    }
}
