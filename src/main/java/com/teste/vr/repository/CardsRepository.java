package com.teste.vr.repository;

import com.teste.vr.Models.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Cards, Long> {
    Cards findOneByNumber(String numeroCartao);
}
