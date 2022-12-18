package com.minejava.userservice.service;

import org.springframework.stereotype.Service;

import com.minejava.userservice.dto.UserDataService;
import com.minejava.userservice.mapper.UserMapper;
import com.minejava.userservice.model.User;
import com.minejava.utilservice.exceptions.NotFoundException;
import com.minejava.utilservice.http.ServerAddress;
import com.minejava.utilservice.payload.UserPayload;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {
    private final UserDataService userDataService;
    private final UserMapper userMapper;
    private final ServerAddress serverAddress;

    public UserService(UserDataService userDataService, UserMapper userMapper, ServerAddress serverAddress) {
        this.userDataService = userDataService;
        this.userMapper = userMapper;
        this.serverAddress = serverAddress;
    }

    public Flux<UserPayload> getAllUsers() {
        return userDataService.getAllUsers()
                .map(userMapper::userServiceToUserPayload)
                .map(u -> {u.setServiceAddress(serverAddress.getHostAddress()); return u;});
    }

    public Mono<UserPayload> getUserById(String userId) {
        return userDataService.getUserById(userId)
                .switchIfEmpty(Mono.error(new NotFoundException("No user found with id: " + userId)))
                .map(userMapper::userServiceToUserPayload)
                .map(u -> {u.setServiceAddress(serverAddress.getHostAddress()); return u;});
    }

    public Mono<UserPayload> getUserByEmail(String email) {
        return userDataService.getUserByEmail(email)
                .switchIfEmpty(Mono.error(new NotFoundException("No user found with email: " + email)))
                .map(userMapper::userServiceToUserPayload)
                .map(u -> {u.setServiceAddress(serverAddress.getHostAddress()); return u;});
    }

    public Mono<UserPayload> getUserByUsername(String username) {
        return userDataService.getUserByUsername(username)
                .switchIfEmpty(Mono.error(new NotFoundException("No user found with username: " + username)))
                .map(userMapper::userServiceToUserPayload)
                .map(u -> {u.setServiceAddress(serverAddress.getHostAddress()); return u;});
    }

    public Mono<Boolean> isUserExists(String id) {
        return userDataService.isUserExists(id);
    }

    public Mono<Boolean> isUserExists(String username, String email) {
        return userDataService.isUserExists(username, email);
    }

    public Mono<User> saveUser(User user) {
        return userDataService.saveUser(user);
    }

    public Mono<Void> deleteUserById(String id) {
        return userDataService.deleteUserById(id);
    }

    public Mono<Void> deleteAllUsers() {
        return userDataService.deleteAllUsers();
    }

    public Mono<Long> countAllUsers() {
        return userDataService.countAllUsers();
    }
}
