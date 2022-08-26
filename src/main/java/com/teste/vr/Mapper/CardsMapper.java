package com.teste.vr.Mapper;

import com.teste.vr.DTOs.CardsDto;
import com.teste.vr.Models.Cards;

public class CardsMapper {
    public static CardsDto cardsToCardsDTO(Cards cards){
        return new CardsDto(cards.getNumber(), cards.getPassword());
    }
}
