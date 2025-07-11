package com.example.demo.controller;

import com.example.demo.dto.request.ApiReponse;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    ApiReponse <User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setResult( userService.createUser(request));
        return apiReponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        return userService.getUser();
    }


    @GetMapping("/{userId}")
    User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return  "User has been deleted";
    }
}
