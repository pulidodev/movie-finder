package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.DirectorDto;
import com.utn.moviefinder.mapper.DirectorMapper;
import com.utn.moviefinder.repository.IDirectorRepository;
import com.utn.moviefinder.service.IDirectorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements IDirectorService {

    private final IDirectorRepository DirectorRepository;

    private final DirectorMapper DirectorMapper;

    @Override
    public List<DirectorDto> getAllDirectors() {
        return DirectorMapper.convertToListDto(DirectorRepository.findAll());
    }

    @Override
    public DirectorDto getDirectorById(Long directorId) {
        return DirectorMapper.convertToDto(DirectorRepository.findById(directorId).orElseThrow());
    }

    @Override
    public DirectorDto createDirector(DirectorDto directorDto) {
        var director = DirectorMapper.convertToEntity(directorDto);
        return DirectorMapper.convertToDto(DirectorRepository.save(director));
    }

    @Override
    public DirectorDto updateDirector(Long directorId, DirectorDto directorDto) {
        var director = DirectorRepository.findById(directorId).orElseThrow();
        return DirectorMapper.convertToDto(DirectorRepository.save(director));
    }

    @Override
    public void deleteDirector(Long directorId) {
        DirectorRepository.deleteById(directorId);
    }
}
