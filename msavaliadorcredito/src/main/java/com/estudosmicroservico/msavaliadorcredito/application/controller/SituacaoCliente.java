package com.estudosmicroservico.msavaliadorcredito.application.controller;

import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosCliente;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SituacaoCliente {

    private DadosCliente cliente;
    private List<CartaoCliente> cartoes;

}
