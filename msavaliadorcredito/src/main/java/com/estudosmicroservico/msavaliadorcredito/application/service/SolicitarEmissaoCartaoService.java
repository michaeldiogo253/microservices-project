package com.estudosmicroservico.msavaliadorcredito.application.service;

import com.estudosmicroservico.msavaliadorcredito.application.controller.response.ProtocoloSolicitacaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosSolicitacaoEmissaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroSolicitacaoCartaoException;
import com.estudosmicroservico.msavaliadorcredito.application.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SolicitarEmissaoCartaoService {

    private final SolicitacaoEmissaoCartaoPublisher solicitacaoEmissaoCartaoPublisher;

    public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados){

        try {

            solicitacaoEmissaoCartaoPublisher.solicitacaoCartao(dados);

            return new ProtocoloSolicitacaoCartao(UUID.randomUUID()
                                                      .toString());


        } catch (Exception e){

            throw new ErroSolicitacaoCartaoException(e.getMessage());

        }

    }


}
