package com.teste.vr.controller;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.service.CardsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@Controller
@RequestMapping("/cartoes")
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @PostMapping(path = "")
    @ApiOperation(value = "Criar um cartão")
    public ResponseEntity<CardsDto> createCard(
            @Valid @RequestBody CardsDto request
    ){
        return this.cardsService.createCard(request);
    }

    @GetMapping(path = "/{cardNumber}")
    @ApiOperation(value = "Obter saldo do Cartão")
    public ResponseEntity<BigDecimal> getBalance(
            @RequestParam
            String cardNumber
    ){
        return this.cardsService.getBalanceByCardNumber(cardNumber);
    }
}
