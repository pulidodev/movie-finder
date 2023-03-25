package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.ActorDetailsDto;
import com.utn.moviefinder.dto.ActorListDto;
import com.utn.moviefinder.mapper.ActorMapper;
import com.utn.moviefinder.repository.IActorRepository;
import com.utn.moviefinder.service.IActorService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final IActorRepository actorRepository;

    private final ActorMapper actorMapper;

    @Override
    public List<ActorListDto> getAllActors() {
        return actorMapper.convertToListDto(actorRepository.findAll());
    }

    @Override
    public ActorDetailsDto getActorById(Long actorId) {
        var actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with ID: " + actorId));
        return actorMapper.convertToDto(actor);
    }

    @Override
    public ActorDetailsDto createActor(ActorDetailsDto actorDto) {
        if (actorDto.getFullName() == null || actorDto.getFullName().isEmpty()) {
            throw new IllegalArgumentException("Actor name cannot be empty or null.");
        }
        var actor = actorMapper.convertToEntity(actorDto);
        return actorMapper.convertToDto(actorRepository.save(actor));
    }

    @Override
    public ActorDetailsDto updateActor(Long actorId, ActorDetailsDto actorDto) {
        var actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with ID: " + actorId));
        if (actorDto.getFullName() != null && !actorDto.getFullName().isEmpty()) {
            actor.setFullName(actorDto.getFullName());
        }
        return actorMapper.convertToDto(actorRepository.save(actor));
    }

    @Override
    public void deleteActor(Long actorId) {
        try {
            actorRepository.deleteById(actorId);
        } catch (EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException("Actor not found with ID: " + actorId);
        }
    }
}
