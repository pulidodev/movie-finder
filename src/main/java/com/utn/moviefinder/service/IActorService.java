package com.utn.moviefinder.service;

import java.util.List;

import com.utn.moviefinder.dto.ActorDetailsDto;
import com.utn.moviefinder.dto.ActorListDto;

public interface IActorService {

    List<ActorListDto> getAllActors();

    ActorDetailsDto getActorById(Long actorId);

    // getActorByNationalityId
    // getActorByOrderByBirthdateASC/DESC
    // getActorByOrderByReleaseDateASC/DESC
    // getActorByOrderByRatingASC/DESC

    ActorDetailsDto createActor(ActorDetailsDto actorDto);

    ActorDetailsDto updateActor(Long actorId, ActorDetailsDto actorDto);

    void deleteActor(Long actorId);
}
