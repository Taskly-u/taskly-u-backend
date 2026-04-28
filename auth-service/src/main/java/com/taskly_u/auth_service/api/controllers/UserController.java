package com.taskly_u.auth_service.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskly_u.auth_service.api.dto.request.CreateUserRequest;
import com.taskly_u.auth_service.api.dto.response.UserResponse;
import com.taskly_u.auth_service.infrastructure.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest request){
        return ResponseEntity.ok(this.userService.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

}
