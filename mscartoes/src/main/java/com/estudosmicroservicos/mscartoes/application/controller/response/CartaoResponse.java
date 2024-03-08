package com.estudosmicroservicos.mscartoes.application.controller.response;

import com.estudosmicroservicos.mscartoes.application.domain.BandeiraCartao;
import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CartaoResponse {

    Long id;
    String nome;
    BandeiraCartao bandeira;
    BigDecimal renda;
    BigDecimal limiteBasico;

    public CartaoResponse(Cartao cartao) {

        this.id = cartao.getId();
        this.nome = cartao.getNome();
        this.bandeira = cartao.getBandeira();
        this.renda = cartao.getRenda();
        this.limiteBasico = cartao.getLimiteBasico();
    }
}
