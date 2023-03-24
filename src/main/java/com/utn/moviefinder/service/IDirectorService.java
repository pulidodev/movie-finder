package com.utn.moviefinder.service;

import java.util.List;

import com.utn.moviefinder.dto.DirectorDto;

public interface IDirectorService {

    List<DirectorDto> getAllDirectors();

    DirectorDto getDirectorById(Long directorId);

    DirectorDto createDirector(DirectorDto directorDto);

    DirectorDto updateDirector(Long directorId, DirectorDto directorDto);

    void deleteDirector(Long directorId);
}
