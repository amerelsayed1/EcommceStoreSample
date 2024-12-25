package io.amermahsoub.ecommerce_store.services;

import org.springframework.security.core.userdetails.User;
import io.amermahsoub.ecommerce_store.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Replace with actual user fetching logic (e.g., from a database)
        if ("user".equals(username)) {
            return new User("user", new BCryptPasswordEncoder().encode("password"), Collections.emptyList());
        }
        throw new UsernameNotFoundException("User not found");
    }


}
