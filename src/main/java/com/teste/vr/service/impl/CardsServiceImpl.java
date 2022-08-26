package com.teste.vr.service.impl;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.Mapper.CardsMapper;
import com.teste.vr.Models.Cards;
import com.teste.vr.repository.CardsRepository;
import com.teste.vr.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CardsServiceImpl implements CardsService {
    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public ResponseEntity<CardsDto> createCard(CardsDto request) {
        return Optional.ofNullable(this.cardsRepository.findOneByNumber(request.getNumeroCartao()))
                .map(card -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(CardsMapper.cardsToCardsDTO(card)))
                .orElseGet(() -> {
                    Cards cards = new Cards(request.getNumeroCartao(), request.getSenha(), new BigDecimal("500.00"));
                    Cards save = this.cardsRepository.save(cards);

                    return ResponseEntity.status(HttpStatus.CREATED).body(CardsMapper.cardsToCardsDTO(save));
                });
    }

    @Override
    public ResponseEntity<BigDecimal> getBalanceByCardNumber(String cardNumber) {
        return Optional.ofNullable(this.cardsRepository.findOneByNumber(cardNumber))
                .map(card -> ResponseEntity.ok().body(card.getBalance()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public Cards findOneByNumber(String cardNumber){
        return this.cardsRepository.findOneByNumber(cardNumber);
    }

    @Override
    public ResponseEntity<String> checkValidTransaction(Cards cards, String numeroCartao, String senha, BigDecimal valor){
        Optional<Cards> card = Optional.ofNullable(cards);

        return card
                .map(c ->
                    card.filter(c2 -> c2.getPassword().equals(senha))
                        .map(c2 -> card.filter(c3 -> new BigDecimal(String.valueOf(c3.getBalance())).compareTo(new BigDecimal(String.valueOf(valor))) >= 0)
                                .map(c3 -> ResponseEntity.status(HttpStatus.CREATED).body(""))
                                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SALDO_INSUFICIENTE")))
                        .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("SENHA_INVALIDA")))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("CARTAO_INEXISTENTE"));
    }

    @Override
    public Cards saveCard(Cards card){
        return this.cardsRepository.save(card);
    }
}
