package com.estudosmicroservico.msavaliadorcredito.application.controller.response;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CartaoAprovado {

    String cartao;
    String bandeira;
    BigDecimal limiteAprovado;
}
