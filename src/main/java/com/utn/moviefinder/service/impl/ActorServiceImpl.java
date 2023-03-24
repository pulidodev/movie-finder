package com.utn.moviefinder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utn.moviefinder.dto.ActorDetailsDto;
import com.utn.moviefinder.dto.ActorListDto;
import com.utn.moviefinder.mapper.ActorMapper;
import com.utn.moviefinder.repository.IActorRepository;
import com.utn.moviefinder.service.IActorService;

import lombok.RequiredArgsConstructor;

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
        return actorMapper.convertToDto(actorRepository.findById(actorId).orElseThrow());
    }

    @Override
    public ActorDetailsDto createActor(ActorDetailsDto ActorDto) {
        var actor = actorMapper.convertToEntity(ActorDto);
        return actorMapper.convertToDto(actorRepository.save(actor));
    }

    @Override
    public ActorDetailsDto updateActor(Long actorId, ActorDetailsDto actorDto) {
        var actor = actorRepository.findById(actorId).orElseThrow();
        return actorMapper.convertToDto(actorRepository.save(actor));
    }

    @Override
    public void deleteActor(Long actorId) {
        actorRepository.deleteById(actorId);
    }
}
