package com.almasabdykadyr.userservice.controller;

import com.almasabdykadyr.userservice.dto.UserRequest;
import com.almasabdykadyr.userservice.dto.UserResponse;
import com.almasabdykadyr.userservice.dto.UserUpdateRequest;
import com.almasabdykadyr.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(userService.saveUser(userRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> updateUserById(@PathVariable String id, @RequestBody UserUpdateRequest request) {

        return ResponseEntity.ok(userService.updateUserById(id, request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id) {

        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
