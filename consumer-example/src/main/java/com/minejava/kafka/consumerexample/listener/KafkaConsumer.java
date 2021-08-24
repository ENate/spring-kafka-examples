package com.minejava.kafka.consumerexample.listener;

import com.minejava.kafka.consumerexample.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    // some message to consumer: provide singe or multiple topics
    // Also specify group_Id and assign topus
    @KafkaListener(topics = "first_topic", clientIdPrefix = "group_Id")
    public void consume(String message) {
        logger.info("Message consumed: {}", message);
    }

    @KafkaListener(topics = "Kafka_Example_json", clientIdPrefix = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        logger.info("Consumed JSON Message: {}", user);
    }

}
