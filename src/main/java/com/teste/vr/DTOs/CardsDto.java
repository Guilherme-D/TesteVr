package com.teste.vr.DTOs;

import javax.validation.constraints.*;

public class CardsDto {

    @Pattern(regexp="[\\d]{16}", message = "Campo numeroCartao deve possuir 16 digitos" )
    @NotNull(message = "Campo numeroCartao não pode ser nulo")
    @NotEmpty(message = "Campo numeroCartao não pode ser nulo")
    private String numeroCartao;

    @NotNull(message = "Campo senha não pode ser nulo")
    @NotEmpty(message = "Campo senha não pode ser vazio")
    private String senha;

    public CardsDto() {
    }

    public CardsDto(String numeroCartao, String senha) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
