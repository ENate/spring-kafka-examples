package com.minejava.collectservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.minejava")
@SpringBootApplication
public class CollectServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectServiceApplication.class, args);
    }
}
