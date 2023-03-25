package com.utn.moviefinder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.moviefinder.dto.MovieDetailsDto;
import com.utn.moviefinder.dto.MovieListDto;
import com.utn.moviefinder.service.IMovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/movies")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class MovieController {

    private final IMovieService MovieService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieListDto>> getAllMovies() {
        return new ResponseEntity<>(MovieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDetailsDto> getMovieById(@PathVariable Long movieId) {
        return new ResponseEntity<>(MovieService.getMovieById(movieId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<MovieDetailsDto> createMovie(@RequestBody MovieDetailsDto movieDto) {
        return new ResponseEntity<>(MovieService.createMovie(movieDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{movieId}/update")
    public ResponseEntity<MovieDetailsDto> updateMovie(@PathVariable Long movieId,
            @RequestBody MovieDetailsDto movieDto) {
        return new ResponseEntity<>(MovieService.updateMovie(movieId, movieDto), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{movieId}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable Long movieId) {
        MovieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie successfully deleted", HttpStatus.ACCEPTED);
    }
}
