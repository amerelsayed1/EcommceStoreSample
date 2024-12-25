package io.amermahsoub.ecommerce_store.controllers;

import io.amermahsoub.ecommerce_store.dto.AuthenticationResponse;
import io.amermahsoub.ecommerce_store.models.LoginRequest;
import io.amermahsoub.ecommerce_store.models.RegisterRequest;
import io.amermahsoub.ecommerce_store.services.AuthService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
