package io.amermahsoub.ecommerce_store.controllers;

import io.amermahsoub.ecommerce_store.dto.response.AuthenticationResponse;
import io.amermahsoub.ecommerce_store.dto.request.LoginRequestDTO;
import io.amermahsoub.ecommerce_store.dto.request.RegisterRequestDTO;
import io.amermahsoub.ecommerce_store.services.AuthService;
import jakarta.validation.Valid;
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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid  RegisterRequestDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
