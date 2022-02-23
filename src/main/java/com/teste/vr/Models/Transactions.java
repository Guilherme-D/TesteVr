package com.teste.vr.Models;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Min(0)
    @NotNull(message = "Campo value não pode ser nulo")
    private Double value;

    public Transactions() {
    }

    public Transactions(Cards card, Double value) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
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
