package com.utn.moviefinder.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utn.moviefinder.dto.MovieDetailsDto;
import com.utn.moviefinder.dto.MovieListDto;
import com.utn.moviefinder.model.Movie;
import com.utn.moviefinder.util.MapperUtil;

@Component
public class MovieMapper {

    public MovieDetailsDto convertToDto(Movie movie) {
        return MapperUtil.map(movie, MovieDetailsDto.class);
    }

    public Movie convertToEntity(MovieDetailsDto movieDetailsDto) {
        return MapperUtil.map(movieDetailsDto, Movie.class);
    }

    public List<MovieListDto> convertToListDto(List<Movie> movieList) {
        return MapperUtil.mapList(movieList, MovieListDto.class);
    }

    public List<Movie> convertToEntityList(List<MovieListDto> movieListDto) {
        return MapperUtil.mapList(movieListDto, Movie.class);
    }
}
