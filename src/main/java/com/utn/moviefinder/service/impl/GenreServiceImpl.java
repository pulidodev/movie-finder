package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.GenreDto;
import com.utn.moviefinder.mapper.GenreMapper;
import com.utn.moviefinder.repository.IGenreRepository;
import com.utn.moviefinder.service.IGenreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements IGenreService {

    private final IGenreRepository GenreRepository;

    private final GenreMapper GenreMapper;

    @Override
    public List<GenreDto> getAllGenres() {
        return GenreMapper.convertToListDto(GenreRepository.findAll());
    }

    @Override
    public GenreDto getGenreById(Long genreId) {
        return GenreMapper.convertToDto(GenreRepository.findById(genreId).orElseThrow());
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        var genre = GenreMapper.convertToEntity(genreDto);
        return GenreMapper.convertToDto(GenreRepository.save(genre));
    }

    @Override
    public GenreDto updateGenre(Long genreId, GenreDto genreDto) {
        var genre = GenreRepository.findById(genreId).orElseThrow();
        return GenreMapper.convertToDto(GenreRepository.save(genre));
    }

    @Override
    public void deleteGenre(Long genreId) {
        GenreRepository.deleteById(genreId);
    }
}
