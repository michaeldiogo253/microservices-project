package com.estudosmicroservico.msavaliadorcredito.application.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CartaoResponse {

    Long id;
    String nome;
    String bandeira;
    BigDecimal renda;
    BigDecimal limiteBasico;
}
