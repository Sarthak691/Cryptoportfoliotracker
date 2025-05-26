package com.bridgelabz.cryptotracker.user.controller;

import com.bridgelabz.cryptotracker.user.entity.User;
import com.bridgelabz.cryptotracker.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    // Spring will give us the UserService automatically
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        return userService.registerUser(name, email, password);
    }

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
