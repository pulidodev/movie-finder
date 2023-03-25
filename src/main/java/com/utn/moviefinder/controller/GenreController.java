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

import com.utn.moviefinder.dto.GenreDto;
import com.utn.moviefinder.service.IGenreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/genres")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class GenreController {

    private final IGenreService GenreService;

    @GetMapping("/all")
    public ResponseEntity<List<GenreDto>> getAllGenres() {
        return new ResponseEntity<>(GenreService.getAllGenres(), HttpStatus.OK);
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<GenreDto> getGenreById(@PathVariable Long genreId) {
        return new ResponseEntity<>(GenreService.getGenreById(genreId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(GenreService.createGenre(genreDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{genreId}/update")
    public ResponseEntity<GenreDto> updateGenre(@PathVariable Long genreId,
            @RequestBody GenreDto genreDto) {
        return new ResponseEntity<>(GenreService.updateGenre(genreId, genreDto), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{genreId}/delete")
    public ResponseEntity<String> deleteGenre(@PathVariable Long genreId) {
        GenreService.deleteGenre(genreId);
        return new ResponseEntity<>("Genre successfully deleted", HttpStatus.ACCEPTED);
    }
}
