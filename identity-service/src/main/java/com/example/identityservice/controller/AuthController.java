package com.example.identityservice.controller;

import com.example.identityservice.dto.AuthRequest;
import com.example.identityservice.dto.TokenDto;
import com.example.identityservice.service.AuthService;
import com.example.identityservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public String createUser(@RequestBody AuthRequest authRequest) {
        return authService.saveUser(authRequest);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        return authService.getToken(authRequest);
    }

    @PostMapping("/validate")
    public String validateToken(@RequestBody TokenDto token) {
        if (jwtService.validateToken(token.accessToken())) {
            return "Token is valid";
        }
        return "Token is invalid";
    }
}
