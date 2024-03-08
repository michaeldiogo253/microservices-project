package com.estudosmicroservicos.mscartoes.application.controller.response;

import com.estudosmicroservicos.mscartoes.application.domain.ClienteCartao;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class ClienteCartaoResponse {

    String cpf;
    CartaoResponse cartao;
    BigDecimal limite;

    public ClienteCartaoResponse(ClienteCartao clienteCartao) {

        this.cpf = clienteCartao.getCpf();
        this.cartao = new CartaoResponse(clienteCartao.getCartao());
        this.limite = clienteCartao.getLimite();
    }
}
