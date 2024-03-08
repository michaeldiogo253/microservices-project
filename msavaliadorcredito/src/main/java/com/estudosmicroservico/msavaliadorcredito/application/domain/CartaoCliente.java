package com.estudosmicroservico.msavaliadorcredito.application.domain;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CartaoCliente {

    String cpf;
    CartaoResponse cartao;
    BigDecimal limite;


}
