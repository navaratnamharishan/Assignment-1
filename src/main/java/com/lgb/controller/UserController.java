package com.lgb.controller;

import com.lgb.dto.LoginDto;
import com.lgb.dto.UserDto;
import com.lgb.response.LoginResponse;
import com.lgb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        LoginResponse response = userService.login(loginDto.getUsername(), loginDto.getPassword());
        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.register(userDto));
    }
}
