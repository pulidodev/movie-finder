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
public class ActorDetailsDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String birthdate;

    private String nationality;

    private List<MovieListDto> movies;
}
