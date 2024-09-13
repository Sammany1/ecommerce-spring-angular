package com.example.ecommerceapi.controller;

import com.example.ecommerceapi.dto.LoginRequest;
import com.example.ecommerceapi.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/api/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            logger.info("User details loaded for username: {}", loginRequest.getUsername());

            // Authenticate user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("User authenticated successfully for username: {}", loginRequest.getUsername());

            return "Login successful";
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for username: {}", loginRequest.getUsername(), e);
            return "Login failed: " + e.getMessage();
        }
    }
}