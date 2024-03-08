package com.microservices.cursoudemy.msclientes.controller.request;

import com.microservices.cursoudemy.msclientes.domain.Cliente;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class CadastrarClienteRequest {

    @NotBlank String nome;
    @NotBlank String cpf;
    @NotNull LocalDate dataNascimento;


   public Cliente toModel(){
        return new Cliente(this.nome, this.cpf, this.dataNascimento);
    }

}
