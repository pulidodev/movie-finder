package com.utn.moviefinder.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.moviefinder.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}