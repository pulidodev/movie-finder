package com.utn.moviefinder.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.utn.moviefinder.dto.GenreDto;
import com.utn.moviefinder.model.Genre;
import com.utn.moviefinder.util.MapperUtil;

@Component
public class GenreMapper {

    public GenreDto convertToDto(Genre genre) {
        return MapperUtil.map(genre, GenreDto.class);
    }

    public Genre convertToEntity(GenreDto genreDto) {
        return MapperUtil.map(genreDto, Genre.class);
    }

    public List<GenreDto> convertToListDto(List<Genre> genreList) {
        return MapperUtil.mapList(genreList, GenreDto.class);
    }

    public List<Genre> convertToEntityList(List<GenreDto> genreListDto) {
        return MapperUtil.mapList(genreListDto, Genre.class);
    }
}
