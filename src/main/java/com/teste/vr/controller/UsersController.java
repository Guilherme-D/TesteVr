package com.teste.vr.controller;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.service.CardsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/cartoes")
public class UsersController {

    @Autowired
    private CardsService cardsService;

    @PostMapping(path = "")
    @ApiOperation(value = "Criar um cartão")
    public ResponseEntity<CardsDto> createCard(
            @Valid @RequestBody CardsDto request
    ){
        return this.cardsService.createCard(request);
    }

}
