package com.minejava.producerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.minejava.producerservice.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private static final String TOPIC_BUILDER = "builder_topic_json";


    @Autowired
    private KafkaTemplate<String, User> myKafkaTemplate;

    public void createProduct(User userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .department(userRequest.getDepartment())
                .salary(userRequest.getSalary())
                .build();
        
        // save in kafka
        myKafkaTemplate.send(TOPIC_BUILDER, user);
        log.info("Saved data in kafka successfully");
        log.info("JSON message {} is saved", user.getName());
    }
}
