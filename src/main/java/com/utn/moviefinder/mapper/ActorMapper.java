package com.utn.moviefinder.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utn.moviefinder.dto.ActorDetailsDto;
import com.utn.moviefinder.dto.ActorListDto;
import com.utn.moviefinder.model.Actor;
import com.utn.moviefinder.util.MapperUtil;

@Component
public class ActorMapper {

    public ActorDetailsDto convertToDto(Actor actor) {
        return MapperUtil.map(actor, ActorDetailsDto.class);
    }

    public Actor convertToEntity(ActorDetailsDto actorDto) {
        return MapperUtil.map(actorDto, Actor.class);
    }

    public List<ActorListDto> convertToListDto(List<Actor> actorList) {
        return MapperUtil.mapList(actorList, ActorListDto.class);
    }

    public List<Actor> convertToEntityList(List<ActorDetailsDto> actorListDto) {
        return MapperUtil.mapList(actorListDto, Actor.class);
    }
}
