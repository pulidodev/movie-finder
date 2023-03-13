package com.utn.moviefinder.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.utn.moviefinder.config.jwt.JwtProvider;
import com.utn.moviefinder.dto.AuthRequestDto;
import com.utn.moviefinder.dto.AuthResponseDto;
import com.utn.moviefinder.dto.RegisterRequestDto;
import com.utn.moviefinder.model.User;
import com.utn.moviefinder.repository.IUserRepository;
import com.utn.moviefinder.service.IAuthService;
import com.utn.moviefinder.util.enums.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

        private final IUserRepository userRepository;

        private final PasswordEncoder passwordEncoder;

        private final JwtProvider jwtProvider;

        private final AuthenticationManager authenticationManager;

        @Override
        public AuthResponseDto register(RegisterRequestDto request) {

                var userOptional = userRepository.findByUsername(request.getUsername());
                if (userOptional.isPresent()) {
                        throw new RuntimeException("Username already in use");
                }

                var user = User.builder()
                                .username(request.getUsername())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER.name())
                                .build();

                userRepository.save(user);

                var jwt = jwtProvider.generateToken(user);

                return AuthResponseDto.builder()
                                .role(user.getRole())
                                .token(jwt)
                                .build();
        }

        @Override
        public AuthResponseDto login(AuthRequestDto request) {

                try {
                        authenticationManager
                                        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),
                                                        request.getPassword()));
                } catch (AuthenticationException e) {
                        throw new BadCredentialsException("Incorrect username or password", e);
                }

                var user = userRepository.findByUsername(request.getUsername()).orElseThrow();
                var jwt = jwtProvider.generateToken(user);

                return AuthResponseDto.builder()
                                .role(user.getRole())
                                .token(jwt)
                                .build();
        }
}