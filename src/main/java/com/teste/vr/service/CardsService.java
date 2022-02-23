package com.teste.vr.service;

import com.teste.vr.DTOs.CardsDto;
import org.springframework.http.ResponseEntity;

public interface CardsService {
    ResponseEntity<CardsDto> createCard(CardsDto request);
}
