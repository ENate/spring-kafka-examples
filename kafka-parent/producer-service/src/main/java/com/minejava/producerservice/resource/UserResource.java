package com.minejava.producerservice.resource;

import com.minejava.producerservice.model.User;
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
    // Define a kafka package
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    // Define a topic
    private static final String TOPIC = "producer_topic_json";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final  String name) {
        kafkaTemplate.send(TOPIC, new User(name, "Cynic Pholosophy", 3400L));
        return "Published Successfully!!!";
    }
}
