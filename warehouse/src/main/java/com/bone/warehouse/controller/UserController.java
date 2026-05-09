package com.bone.warehouse.controller;

import com.bone.warehouse.dto.request.ApiResponse;
import com.bone.warehouse.dto.request.UserCreateRequest;
import com.bone.warehouse.dto.request.UserDeleteRequest;
import com.bone.warehouse.dto.request.UserUpdateRequest;
import com.bone.warehouse.entity.User;
import com.bone.warehouse.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(request));
        return response;
    }

    @GetMapping("/users")
    ApiResponse<List<User>> getUsers() {
        ApiResponse<List<User>> response = new ApiResponse<>();
        response.setResult(userService.getUsers());
        return response;
    }

    @GetMapping("/users/{id}")
    ApiResponse<User> getUserById(@PathVariable String id){
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.getUserById(id));
        return response;
    }

    @PutMapping("/users/{id}")
    User updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(id, request);
    }

    @PutMapping("/users/delete/{id}")
    User deleteUser(@PathVariable String id, @RequestBody UserDeleteRequest request) {
        return userService.deleteUser(id, request);
    }
}
