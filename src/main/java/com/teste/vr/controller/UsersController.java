package com.teste.vr.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cartoes")
public class UsersController {


    @GetMapping(path = "")
    @ApiOperation(value = "Criar um cartão")
    public ResponseEntity<String> createCard(){

        return ResponseEntity.ok().body("ok");
    }

}
