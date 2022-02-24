package com.teste.vr.Models;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Campo cards não pode ser nulo")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cards card;

    @DecimalMin(value = "0.01", inclusive = false, message = "Campo value deve ser no mínimo 0.01")
    @Digits(integer=20, fraction=2, message = "Campo value pode conter até 20 casas inteiras e 2 decimais")
    @NotNull(message = "Campo value não pode ser nulo")
    private BigDecimal value;

    public Transactions() {
    }

    public Transactions(Cards card, BigDecimal value) {
        this.card = card;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equal(id, that.id) && Objects.equal(card, that.card) && Objects.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, card, value);
    }
}
