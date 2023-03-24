package com.utn.moviefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.moviefinder.model.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long> {

}