package com.minejava.collectservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minejava.collectservice.service.CollectService;
import com.minejava.utilservice.payload.UserPayload;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/collect-service")
public class CollectController {
    private final CollectService collectService;

    public CollectController(CollectService collectService) {
        this.collectService = collectService;
    }

    @PostMapping("/user")
    public Mono<UserPayload> createUser(@RequestBody UserPayload user) {
        return collectService.createUser(user);
    }

    @GetMapping("/user")
    public Flux<UserPayload> getAllUsers() {
        return collectService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public Mono<UserPayload> getUser(@PathVariable String userId) {
        return collectService.getUserById(userId);
    }

    @DeleteMapping("/user/{userId}")
    public Mono<Void> deleteUser(@PathVariable String userId) {
        return collectService.deleteUser(userId);
    }
}
