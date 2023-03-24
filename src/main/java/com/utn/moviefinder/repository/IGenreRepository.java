package com.utn.moviefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.moviefinder.model.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long> {

}
