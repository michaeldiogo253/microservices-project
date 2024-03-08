package com.estudosmicroservicos.mscartoes.application.controller.request;

import com.estudosmicroservicos.mscartoes.application.domain.BandeiraCartao;
import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CadastrarCartaoRequest {

    @NotBlank String nome;
    @NotNull BandeiraCartao bandeira;
    @NotNull BigDecimal renda;
    @NotNull BigDecimal limiteBasico;

    public Cartao toModel() {

        return new Cartao(this.nome, this.bandeira, this.renda, this.limiteBasico);
    }

}
