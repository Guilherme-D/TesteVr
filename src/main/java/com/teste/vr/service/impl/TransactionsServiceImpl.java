package com.teste.vr.service.impl;

import com.teste.vr.DTOs.TransactionsDto;
import com.teste.vr.Models.Cards;
import com.teste.vr.Models.Transactions;
import com.teste.vr.repository.TransactionsRepository;
import com.teste.vr.service.CardsService;
import com.teste.vr.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CardsService cardsService;

    @Override
    @Transactional
    public ResponseEntity<String> createTransaction(TransactionsDto request) {
        Cards card = this.cardsService.findOneByNumber(request.getNumeroCartao());

        return Optional.of(this.cardsService.checkValidTransaction(
            card, request.getNumeroCartao(), request.getSenha(), request.getValor()
        )).filter(v -> v.getStatusCode().is4xxClientError())
          .orElseGet(() -> {
                Transactions transactions = new Transactions(card, request.getValor());
                card.setBalance(card.getBalance().subtract(request.getValor()));
                this.transactionsRepository.save(transactions);
                this.cardsService.saveCard(card);
                return ResponseEntity.ok().body("ok");
          });
    }
}
