package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.DirectorDto;
import com.utn.moviefinder.mapper.DirectorMapper;
import com.utn.moviefinder.repository.IDirectorRepository;
import com.utn.moviefinder.service.IDirectorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements IDirectorService {

    private final IDirectorRepository directorRepository;

    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorDto> getAllDirectors() {
        return directorMapper.convertToListDto(directorRepository.findAll());
    }

    @Override
    public DirectorDto getDirectorById(Long directorId) {
        var Director = directorRepository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found with ID: " + directorId));
        return directorMapper.convertToDto(Director);
    }

    @Override
    public DirectorDto createDirector(DirectorDto directorDto) {
        if (directorDto.getFullName() == null || directorDto.getFullName().isEmpty()) {
            throw new IllegalArgumentException("Director name cannot be empty or null.");
        }
        var director = directorMapper.convertToEntity(directorDto);
        return directorMapper.convertToDto(directorRepository.save(director));
    }

    @Override
    public DirectorDto updateDirector(Long directorId, DirectorDto directorDto) {
        var director = directorRepository.findById(directorId)
                .orElseThrow(() -> new EntityNotFoundException("Director not found with ID: " + directorId));
        if (directorDto.getFullName() != null && !directorDto.getFullName().isEmpty()) {
            director.setFullName(directorDto.getFullName());
        }
        return directorMapper.convertToDto(directorRepository.save(director));
    }

    @Override
    public void deleteDirector(Long directorId) {
        try {
            directorRepository.deleteById(directorId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Director not found with ID: " + directorId);
        }
    }
}
