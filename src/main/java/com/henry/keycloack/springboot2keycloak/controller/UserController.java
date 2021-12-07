package com.henry.keycloack.springboot2keycloak.controller;

import com.henry.keycloack.springboot2keycloak.model.User;
import com.henry.keycloack.springboot2keycloak.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/users")
    @RolesAllowed({"user","admin"})
    public ResponseEntity<User> save(@RequestBody User user){
        return  ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/users")
    @RolesAllowed("admin")
    public ResponseEntity<Iterable<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }
}
