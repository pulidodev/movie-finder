package com.utn.moviefinder.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.utn.moviefinder.model.User;
import com.utn.moviefinder.repository.IUserRepository;
import com.utn.moviefinder.util.Role;

import lombok.RequiredArgsConstructor;

@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class DefaultAdminRunner implements ApplicationRunner {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var admin = User.builder()
                .username("admin@moviefinder.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.ADMIN.name())
                .build();

        if (!userRepository.findByUsername(admin.getUsername()).isPresent()) {
            userRepository.save(admin);
        }
    }
}
