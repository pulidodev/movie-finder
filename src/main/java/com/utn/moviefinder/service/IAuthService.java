package com.utn.moviefinder.service;

import com.utn.moviefinder.dto.AuthRequestDto;
import com.utn.moviefinder.dto.AuthResponseDto;
import com.utn.moviefinder.dto.RegisterRequestDto;

public interface IAuthService {

    public AuthResponseDto register(RegisterRequestDto request);

    public AuthResponseDto login(AuthRequestDto request);
}
