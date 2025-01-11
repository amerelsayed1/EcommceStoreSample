package io.amermahsoub.ecommerce_store.config;

import io.jsonwebtoken.ExpiredJwtException;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws IOException {
        try {
            final String authHeader = request.getHeader("Authorization");

            // Handle missing or empty auth header
            /*if (authHeader == null || authHeader.isEmpty() ) {
                handleAuthenticationException(response, "Authorization header is missing");
                return;
            }*/

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }

            final String jwtToken = authHeader.substring(7);
            final String email;

            try {
                email = jwtService.extractUserName(jwtToken);
            } catch (ExpiredJwtException e) {
                handleAuthenticationException(response, "JWT token has expired");
                return;
            }

            if (email == null) {
                handleAuthenticationException(response, "Invalid JWT token");
                return;
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);

                try {
                    if (!jwtService.isTokenValid(jwtToken, userDetails)) {
                        handleAuthenticationException(response, "Invalid JWT token");
                        return;
                    }

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                } catch (ExpiredJwtException e) {
                    handleAuthenticationException(response, "JWT token has expired");
                    return;
                }
            }

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            handleAuthenticationException(response, "Authentication failed: " + e.getMessage());
        }
    }

    private void handleAuthenticationException(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + message + "\"}");
    }
}