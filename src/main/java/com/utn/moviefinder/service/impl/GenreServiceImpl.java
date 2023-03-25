package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.GenreDto;
import com.utn.moviefinder.mapper.GenreMapper;
import com.utn.moviefinder.repository.IGenreRepository;
import com.utn.moviefinder.service.IGenreService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements IGenreService {

    private final IGenreRepository genreRepository;

    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAllGenres() {
        return genreMapper.convertToListDto(genreRepository.findAll());
    }

    @Override
    public GenreDto getGenreById(Long genreId) {
        var genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found with ID: " + genreId));
        return genreMapper.convertToDto(genre);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        if (genreDto.getName() == null || genreDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Genre name cannot be empty or null.");
        }
        var genre = genreMapper.convertToEntity(genreDto);
        return genreMapper.convertToDto(genreRepository.save(genre));
    }

    @Override
    public GenreDto updateGenre(Long genreId, GenreDto genreDto) {
        var genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found with ID: " + genreId));
        if (genreDto.getName() != null && !genreDto.getName().isEmpty()) {
            genre.setName(genreDto.getName());
        }
        return genreMapper.convertToDto(genreRepository.save(genre));
    }

    @Override
    public void deleteGenre(Long genreId) {
        try {
            genreRepository.deleteById(genreId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Genre not found with ID: " + genreId);
        }
    }
}
