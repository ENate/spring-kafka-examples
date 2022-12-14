package com.minejava.collectservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class CollectService {
    private static final Logger LOG = LoggerFactory.getLogger(CompositeService.class);
    private static final String USER_REQ_MAP = "/user";
    private static final String PRODUCER_BINDING_NAME = "userProducer-out-0";

    private final String userServiceUrl;
    private final WebClient webClient;
    private final ObjectMapper mapper;

    private final StreamBridge streamBridge;

    @Autowired
    public CollectService(
            @Value("${app.user-service.host}") String userServiceHost,
            @Value("${app.user-service.port}") int userServicePort,
            WebClient.Builder webClient, ObjectMapper mapper, StreamBridge streamBridge) {

        this.userServiceUrl = "http://" + userServiceHost + ":" + userServicePort + USER_REQ_MAP;
        this.webClient = webClient.build();
        this.mapper = mapper;
        this.streamBridge = streamBridge;
    }
}
