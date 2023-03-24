package com.utn.moviefinder.service;

import java.util.List;

import com.utn.moviefinder.dto.GenreDto;

public interface IGenreService {

    List<GenreDto> getAllGenres();

    GenreDto getGenreById(Long genreId);

    GenreDto createGenre(GenreDto genreDto);

    GenreDto updateGenre(Long genreId, GenreDto genreDto);

    void deleteGenre(Long genreId);
}
