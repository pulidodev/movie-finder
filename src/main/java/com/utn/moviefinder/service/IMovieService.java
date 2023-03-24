package com.utn.moviefinder.service;

import java.util.List;

import com.utn.moviefinder.dto.MovieDetailsDto;
import com.utn.moviefinder.dto.MovieListDto;

public interface IMovieService {

    List<MovieListDto> getAllMovies();

    MovieDetailsDto getMovieById(Long movieId);

    // getMovieByDirectorId
    // getMovieByActorId
    // getMovieByOrderByTitleASC/DESC
    // getMovieByOrderByReleaseDateASC/DESC
    // getMovieByOrderByRatingASC/DESC
    // getMovieByGenre

    MovieDetailsDto createMovie(MovieDetailsDto movieDto);

    MovieDetailsDto updateMovie(Long movieId, MovieDetailsDto movieDto);

    void deleteMovie(Long movieId);
}
