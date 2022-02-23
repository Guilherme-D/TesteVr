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

import java.util.Optional;

@Service
public class CardsServiceImpl implements CardsService {
    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public ResponseEntity<CardsDto> createCard(CardsDto request) {
        ResponseEntity<CardsDto> cardsDtoResponseEntity = Optional.ofNullable(this.cardsRepository.findOneByNumber(request.getNumeroCartao()))
                .map(card -> ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(CardsMapper.cardsToCardsDTO(card)))
                .orElseGet(() -> {
                    Cards cards = new Cards(request.getNumeroCartao(), request.getSenha(), 500.00);
                    Cards save = this.cardsRepository.save(cards);

                    return ResponseEntity.status(HttpStatus.CREATED).body(CardsMapper.cardsToCardsDTO(save));
                });
        return cardsDtoResponseEntity;
    }

    @Override
    public ResponseEntity<Double> getBalanceByCardNumber(String cardNumber) {
        ResponseEntity<Double> doubleResponseEntity = Optional.ofNullable(this.cardsRepository.findOneByNumber(cardNumber))
                .map(card -> ResponseEntity.ok().body(card.getBalance()))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
        return doubleResponseEntity;
    }
}
