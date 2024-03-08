package com.estudosmicroservico.msavaliadorcredito.application.controller.response;

import lombok.Value;

import java.math.BigDecimal;
import java.util.List;

@Value
public class AvaliacaoClienteResponse {

    List<CartaoAprovado> cartoes;
}
