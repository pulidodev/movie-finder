package com.utn.moviefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.moviefinder.model.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
