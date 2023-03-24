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

import com.utn.moviefinder.dto.DirectorDto;
import com.utn.moviefinder.service.IDirectorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/directors")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class DirectorController {

    private final IDirectorService DirectorService;

    @GetMapping("/all")
    public ResponseEntity<List<DirectorDto>> getAllDirectors() {
        return new ResponseEntity<>(DirectorService.getAllDirectors(), HttpStatus.OK);
    }

    @GetMapping("/{directorId}")
    public ResponseEntity<DirectorDto> getDirectorById(@PathVariable Long directorId) {
        return new ResponseEntity<>(DirectorService.getDirectorById(directorId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<DirectorDto> createDirector(@RequestBody DirectorDto directorDto) {
        return new ResponseEntity<>(DirectorService.createDirector(directorDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{directorId}/update")
    public ResponseEntity<DirectorDto> updateDirector(@PathVariable Long directorId,
            @RequestBody DirectorDto directorDto) {
        return new ResponseEntity<>(DirectorService.updateDirector(directorId, directorDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{directorId}/delete")
    public ResponseEntity<String> deleteDirector(@PathVariable Long directorId) {
        DirectorService.deleteDirector(directorId);
        return new ResponseEntity<>("Director successfully deleted", HttpStatus.ACCEPTED);
    }
}
