package com.bone.warehouse.controller;

import com.bone.warehouse.dto.request.UserCreateRequest;
import com.bone.warehouse.dto.request.UserDeleteRequest;
import com.bone.warehouse.dto.request.UserUpdateRequest;
import com.bone.warehouse.entity.User;
import com.bone.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    User createUser(@RequestBody UserCreateRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users")
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    User  getUserById(@PathVariable String id){
        return userService.getUserById(id);
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
