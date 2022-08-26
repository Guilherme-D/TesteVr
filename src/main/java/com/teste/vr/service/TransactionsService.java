package com.teste.vr.service;

import com.teste.vr.DTOs.TransactionsDto;
import org.springframework.http.ResponseEntity;

public interface TransactionsService {
    ResponseEntity<String> createTransaction(TransactionsDto request);
}
