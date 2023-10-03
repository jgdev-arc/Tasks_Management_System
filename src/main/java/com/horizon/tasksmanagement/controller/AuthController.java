package com.horizon.tasksmanagement.controller;

import com.horizon.tasksmanagement.dto.LoginDTO;
import com.horizon.tasksmanagement.dto.RegisterDTO;
import com.horizon.tasksmanagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    // Register REST API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        String response = authService.register(registerDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Login REST API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        String response = authService.login(loginDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
