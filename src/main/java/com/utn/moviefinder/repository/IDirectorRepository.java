package com.utn.moviefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utn.moviefinder.model.Director;

public interface IDirectorRepository extends JpaRepository<Director, Long> {

}
