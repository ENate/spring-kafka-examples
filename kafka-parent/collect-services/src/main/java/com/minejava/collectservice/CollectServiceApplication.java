package com.minejava.collectservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectServiceApplication {
    public static void main(String[] args) {
        var cxt = SpringApplication.run(CollectServiceApplication.class, args);
    }
}
