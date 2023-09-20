package com.minejava.producerservice.resource;

import com.minejava.producerservice.model.User;
import com.minejava.producerservice.service.ProduceService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class UserResource {
    // Serialization is performed on the config package
    // Define a kafka package
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private final ProduceService produceService;

    // Define a topic
    private static final String TOPIC = "producer_topic_json";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final  String name) {
        kafkaTemplate.send(TOPIC, new User(name, "Cynic Pholosophy", 3400L));
        return "Published Successfully!!!";
    }

    @PostMapping("/publish/data")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User userRequest) {
        produceService.createUser(userRequest);
    }
}
