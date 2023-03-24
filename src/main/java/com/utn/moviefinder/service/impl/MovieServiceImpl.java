package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.MovieDetailsDto;
import com.utn.moviefinder.dto.MovieListDto;
import com.utn.moviefinder.mapper.MovieMapper;
import com.utn.moviefinder.repository.IMovieRepository;
import com.utn.moviefinder.service.IMovieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository MovieRepository;

    private final MovieMapper MovieMapper;

    @Override
    public List<MovieListDto> getAllMovies() {
        return MovieMapper.convertToListDto(MovieRepository.findAll());
    }

    @Override
    public MovieDetailsDto getMovieById(Long movieId) {
        return MovieMapper.convertToDto(MovieRepository.findById(movieId).orElseThrow());
    }

    @Override
    public MovieDetailsDto createMovie(MovieDetailsDto movieDto) {
        var movie = MovieMapper.convertToEntity(movieDto);
        return MovieMapper.convertToDto(MovieRepository.save(movie));
    }

    @Override
    public MovieDetailsDto updateMovie(Long movieId, MovieDetailsDto movieDto) {
        var movie = MovieRepository.findById(movieId).orElseThrow();
        return MovieMapper.convertToDto(MovieRepository.save(movie));
    }

    @Override
    public void deleteMovie(Long movieId) {
        MovieRepository.deleteById(movieId);
    }
}
