package com.estudosmicroservicos.mscartoes.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ClienteCartao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String cpf;
    @ManyToOne private Cartao cartao;
    private BigDecimal limite;

    public ClienteCartao(String cpf, Cartao cartao, BigDecimal limite) {

        this.cpf = cpf;
        this.cartao = cartao;
        this.limite = limite;
    }
}
