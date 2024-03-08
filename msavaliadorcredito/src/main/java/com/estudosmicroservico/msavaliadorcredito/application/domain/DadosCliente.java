package com.estudosmicroservico.msavaliadorcredito.application.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class DadosCliente {

    Long id;
    String nome;
    LocalDate dataNascimento;

}
