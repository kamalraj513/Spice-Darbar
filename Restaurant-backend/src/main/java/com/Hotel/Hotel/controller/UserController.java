package com.Hotel.Hotel.controller;

import com.Hotel.Hotel.model.User;
import com.Hotel.Hotel.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173") // React dev server
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Signup
    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody User user) {
        Map<String, Object> response = new HashMap<>();
        try {
            User savedUser = userService.signup(user);
            savedUser.setPassword(null); // don't send password back
            response.put("user", savedUser);
            response.put("message", "Signup successful");
        } catch (RuntimeException e) {
            response.put("message", e.getMessage());
        }
        return response;
    }

    // Signin
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Map<String, Object> response = new HashMap<>();
        boolean success = userService.login(email, password);

        if (success) {
            User user = userService.getUserByEmail(email);
            user.setPassword(null);
            response.put("user", user);
            response.put("message", "Login successful");
        } else {
            response.put("message", "Invalid email or password");
        }

        return response;
    }

    @PostMapping("/forgot-password")
    public Map<String, Object> forgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        Map<String, Object> response = new HashMap<>();

        User user = userService.getUserByEmail(email);
        if (user != null) {
            // Instead of sending email, return userId for simulation
            response.put("message", "Password reset ready for user");
            response.put("userId", user.getId());
        } else {
            response.put("message", "Email not found");
        }

        return response;
    }


    // Reset Password
    @PutMapping("/reset-password/{id}")
    public Map<String, String> resetPassword(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String newPassword = request.get("password");
        Map<String, String> response = new HashMap<>();

        User user = userService.getUserById(id);
        if (user != null) {
            user.setPassword(newPassword); // ⚠️ Hash password in real app
            userService.saveUser(user);
            response.put("message", "Password updated successfully");
        } else {
            response.put("message", "User not found");
        }

        return response;
    }
}
