package com.estudosmicroservico.msavaliadorcredito.application.controller.request;

import lombok.Value;

@Value
public class AvaliacaoRequest {

    String cpf;
    Long renda;
}
