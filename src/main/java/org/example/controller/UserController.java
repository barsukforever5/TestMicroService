package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.User;
import org.example.UserService;
import org.springframework.ui.Model;
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

    @GetMapping("/users4")
    @ResponseBody
    public String test() {
        return "WORKS";
    }

    @GetMapping("/users")
    public List<User> list(Model model) {
        return service.findAll();
    }

    @PostMapping("/users/create")
    public String create(@RequestParam String name,
                         @RequestParam int age) {
        User u = new User();
        u.setName(name);
        u.setAge(age);
        service.create(u);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String delete(@RequestParam String key) {
        service.delete(key);
        return "redirect:/users";
    }
}
