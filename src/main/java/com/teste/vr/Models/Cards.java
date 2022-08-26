package com.teste.vr.Models;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Pattern(regexp="[\\d]{16}", message = "Campo numeroCartao deve possuir 16 digitos" )
    @NotNull(message = "Campo numeroCartao não pode ser nulo")
    @NotEmpty(message = "Campo numeroCartao não pode ser nulo")
    private String number;

    @NotNull(message = "Campo password não pode ser nulo")
    @NotEmpty(message = "Campo password não pode ser vazio")
    private String password;

    @Min(value = 0, message = "Valor do saldo não pode ser menor que 0")
    @NotNull(message = "Campo balance não pode ser nulo")
    private BigDecimal balance;

    public Cards() {
    }

    public Cards(String number, String password, BigDecimal balance) {
        this.number = number;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return Objects.equal(id, cards.id) && Objects.equal(number, cards.number) && Objects.equal(password, cards.password) && Objects.equal(balance, cards.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, number, password, balance);
    }
}
