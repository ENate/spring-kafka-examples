package com.minejava.kafka.producerconsumer.resource;

import com.minejava.kafka.producerconsumer.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {
    // Serialization is performed on the config package
    // Define a kafka template
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    // Define some topic
    private static final String TOPIC = "first_topic";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC, new User(name, "Cynic Philosophy", 2000L));
        return "Published Successfully";
    }

}
