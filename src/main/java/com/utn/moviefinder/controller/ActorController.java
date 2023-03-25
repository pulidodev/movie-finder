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

import com.utn.moviefinder.dto.ActorDetailsDto;
import com.utn.moviefinder.dto.ActorListDto;
import com.utn.moviefinder.service.IActorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/actors")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class ActorController {

    private final IActorService actorService;

    @GetMapping("/all")
    public ResponseEntity<List<ActorListDto>> getAllActors() {
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/{actorId}")
    public ResponseEntity<ActorDetailsDto> getActorById(@PathVariable Long actorId) {
        return new ResponseEntity<>(actorService.getActorById(actorId), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ActorDetailsDto> createActor(@RequestBody ActorDetailsDto actorDto) {
        return new ResponseEntity<>(actorService.createActor(actorDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{actorId}/update")
    public ResponseEntity<ActorDetailsDto> updateActor(@PathVariable Long actorId,
            @RequestBody ActorDetailsDto actorDto) {
        return new ResponseEntity<>(actorService.updateActor(actorId, actorDto), HttpStatus.ACCEPTED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{actorId}/delete")
    public ResponseEntity<String> deleteActor(@PathVariable Long actorId) {
        actorService.deleteActor(actorId);
        return new ResponseEntity<>("Actor successfully deleted", HttpStatus.ACCEPTED);
    }
}
