package io.amermahsoub.ecommerce_store.services;

import io.amermahsoub.ecommerce_store.config.JwtService;
import io.amermahsoub.ecommerce_store.dto.response.AuthenticationResponse;
import io.amermahsoub.ecommerce_store.entities.user.Role;
import io.amermahsoub.ecommerce_store.entities.user.User;
import io.amermahsoub.ecommerce_store.dto.request.LoginRequestDTO;
import io.amermahsoub.ecommerce_store.dto.request.RegisterRequestDTO;
import io.amermahsoub.ecommerce_store.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequestDTO registerRequestDTO) {
        var user = User.builder()
                .firstName(registerRequestDTO.getFirstName())
                .lastName(registerRequestDTO.getLastName())
                .email(registerRequestDTO.getEmail())
                .password(passwordEncoder.encode(registerRequestDTO.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
        var user = userRepository.findUserByEmail(loginRequestDTO.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


}
