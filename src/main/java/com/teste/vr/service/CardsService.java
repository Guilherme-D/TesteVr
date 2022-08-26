package com.teste.vr.service;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.Models.Cards;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface CardsService {
    ResponseEntity<CardsDto> createCard(CardsDto request);

    ResponseEntity<BigDecimal> getBalanceByCardNumber(String cardNumber);

    Cards findOneByNumber(String cardNumber);

    ResponseEntity<String> checkValidTransaction(Cards cards, String numeroCartao, String senha, BigDecimal valor);

    Cards saveCard(Cards card);
}
