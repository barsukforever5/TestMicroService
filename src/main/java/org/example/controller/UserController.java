package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.User;
import org.example.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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
    public String list(Model model) {
        model.addAttribute("users", service.findAll());
        return "users";
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
