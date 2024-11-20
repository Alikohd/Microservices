package com.example.identityservice.service;

import com.example.identityservice.dto.AuthRequest;
import com.example.identityservice.entity.User;
import com.example.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String saveUser(AuthRequest authRequest) {
        User user = User.builder().name(authRequest.username())
                .password(authRequest.password()).build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User saved successfully";
    }

    public String getToken(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.username(), authRequest.password()));
        } catch (Exception e) {
            return "Invalid username or password";
        }

        UserDetails user = userService.loadUserByUsername(authRequest.username());
        return jwtService.generateAccessToken(user);
    }


}
