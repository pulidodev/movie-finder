package com.utn.moviefinder.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String nationality;

    private List<MovieListDto> movies;
}
