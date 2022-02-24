package com.teste.vr.DTOs;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TransactionsDto extends CardsDto{

    @DecimalMin(value = "0.01", inclusive = false, message = "Campo valor deve ser no mínimo 0.01")
    @Digits(integer=20, fraction=2, message = "Campo valor pode conter até 20 casas inteiras e 2 decimais")
    @NotNull(message = "Campo valor não pode ser nulo")
    private BigDecimal valor;

    public TransactionsDto() {
    }

    public TransactionsDto(String numeroCartao, String senha, BigDecimal valor) {
        super(numeroCartao, senha);
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
