package com.utn.moviefinder.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsDto {

    private Long id;

    private String title;

    private String description;

    private Date releaseDate;

    private Integer rating;

    private Long genreId;

    private String genreName;

    private Long directorId;

    private String directorFirstName;

    private String directorLastName;

    private List<ActorListDto> actors;
}
