package com.minejava.userservice.message;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;

import com.minejava.userservice.mapper.UserMapper;
import com.minejava.userservice.model.User;
import com.minejava.userservice.service.UserService;
import com.minejava.utilservice.event.DataEvent;
import com.minejava.utilservice.exceptions.BadRequestException;
import com.minejava.utilservice.payload.UserPayload;

@Configuration
public class MessageConsumer {
    private final Logger LOG = LoggerFactory.getLogger(MessageConsumer.class);

    private final UserService userService;
    private final UserMapper userMapper;

    
    public MessageConsumer(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Bean
    public Consumer<DataEvent<String, UserPayload>> userConsumer() {
        return event -> {
            LOG.info("Consuming message event created at {}", event.getEventCreatedAt());

            switch (event.getEventType()) {

                case CREATE:
                    UserPayload userPayload = event.getData();
                    LOG.info("Creating user of the following {}", userPayload);
                    User user = userMapper.userPayloadToUserService(userPayload);
                    userService.saveUser(user)
                            .onErrorMap(
                                    DuplicateKeyException.class,
                                    ex -> new BadRequestException("Duplicate key, username " + user.getUsername() +
                                            " or email address " + user.getEmail() + " had already been used.")
                            )
                            .subscribe(u -> LOG.info("User Created {}", u));
                    break;

                case DELETE:
                    userPayload = event.getData();
                    user = userMapper.userPayloadToUserService(userPayload);
                    String userId = event.getKey() != null ? event.getKey() : user.getId();
                    LOG.info("Deleting user with the following {}", userId);
                    userService.deleteUserById(userId)
                            .subscribe(x -> LOG.info("User with id {} deleted successfully", userId));
                    break;
            }
        };
    }
}
