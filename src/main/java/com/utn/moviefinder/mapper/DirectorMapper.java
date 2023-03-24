package com.utn.moviefinder.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utn.moviefinder.dto.DirectorDto;
import com.utn.moviefinder.model.Director;
import com.utn.moviefinder.util.MapperUtil;

@Component
public class DirectorMapper {

    public DirectorDto convertToDto(Director director) {
        return MapperUtil.map(director, DirectorDto.class);
    }

    public Director convertToEntity(DirectorDto directorDto) {
        return MapperUtil.map(directorDto, Director.class);
    }

    public List<DirectorDto> convertToListDto(List<Director> directorList) {
        return MapperUtil.mapList(directorList, DirectorDto.class);
    }

    public List<Director> convertToEntityList(List<DirectorDto> directorListDto) {
        return MapperUtil.mapList(directorListDto, Director.class);
    }
}
