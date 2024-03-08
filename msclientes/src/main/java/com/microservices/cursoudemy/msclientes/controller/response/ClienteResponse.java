package com.microservices.cursoudemy.msclientes.controller.response;

import com.microservices.cursoudemy.msclientes.domain.Cliente;
import lombok.Value;

import java.time.LocalDate;

@Value
public class ClienteResponse {

    Long id;
    String nome;
    String cpf;
    LocalDate dataNascimento;

    public static ClienteResponse of(Cliente cliente) {

        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getDataNascimento());
    }

}
