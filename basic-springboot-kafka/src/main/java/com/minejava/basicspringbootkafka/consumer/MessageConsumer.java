package com.minejava.basicspringbootkafka.consumer;

import org.springframework.stereotype.Component;

import com.minejava.basicspringbootkafka.repository.MessageRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

@Component
public class MessageConsumer {
    private Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired
    private MessageRepository messageRepo;

    @KafkaListener(topics = "${myapp.kafka.topic}", groupId = "xyz")
    public void consume(String message) {
        log.info("MESSAGE RECEIVED AT CONSUMER END -> " + message);
        messageRepo.addMessage(message);
    }
}
