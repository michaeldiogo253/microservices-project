package com.estudosmicroservicos.mscartoes.application.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosSolicitacaoEmissaoCartao {

    Long idCartao;
    String cpf;
    String endereco;
    BigDecimal limiteLiberado;

}
