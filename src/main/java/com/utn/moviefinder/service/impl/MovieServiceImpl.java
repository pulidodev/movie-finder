package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.MovieDetailsDto;
import com.utn.moviefinder.dto.MovieListDto;
import com.utn.moviefinder.mapper.MovieMapper;
import com.utn.moviefinder.repository.IMovieRepository;
import com.utn.moviefinder.service.IMovieService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public List<MovieListDto> getAllMovies() {
        return movieMapper.convertToListDto(movieRepository.findAll());
    }

    @Override
    public MovieDetailsDto getMovieById(Long movieId) {
        var movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + movieId));
        return movieMapper.convertToDto(movie);
    }

    @Override
    public MovieDetailsDto createMovie(MovieDetailsDto movieDto) {
        if (movieDto.getTitle() == null || movieDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Movie title cannot be empty or null.");
        }
        var movie = movieMapper.convertToEntity(movieDto);
        return movieMapper.convertToDto(movieRepository.save(movie));
    }

    @Override
    public MovieDetailsDto updateMovie(Long movieId, MovieDetailsDto movieDto) {
        var movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with ID: " + movieId));
        if (movieDto.getTitle() != null && !movieDto.getTitle().isEmpty()) {
            movie.setTitle(movieDto.getTitle());
        }
        return movieMapper.convertToDto(movieRepository.save(movie));
    }

    @Override
    public void deleteMovie(Long movieId) {
        try {
            movieRepository.deleteById(movieId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Movie not found with ID: " + movieId);
        }
    }
}
