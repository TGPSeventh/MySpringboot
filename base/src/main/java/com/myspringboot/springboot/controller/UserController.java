package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update User (ID in JSON body)
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return userService.updateUser(user.getId(), user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete User (ID in JSON body)
    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        if (user.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return userService.deleteUser(user.getId())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}