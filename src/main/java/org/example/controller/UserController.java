package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.User;
import org.example.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        System.out.println("USER CONTROLLER LOADED");
    }

    @GetMapping("/users")
    public List<User> list() {
        return service.findAll();
    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @DeleteMapping("/users/{key}")
    public void delete(@PathVariable String key) {
        service.delete(key);
    }
}
