package com.teste.vr.controller;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.DTOs.TransactionsDto;
import com.teste.vr.service.CardsService;
import com.teste.vr.service.TransactionsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/transacoes")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping(path = "")
    @ApiOperation(value = "Realizar uma transação")
    public ResponseEntity<String> createTransaction(
            @Valid @RequestBody TransactionsDto request
    ){
        return this.transactionsService.createTransaction(request);
    }

}
