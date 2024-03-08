package com.estudosmicroservico.msavaliadorcredito.application.controller;

import com.estudosmicroservico.msavaliadorcredito.application.controller.response.ProtocoloSolicitacaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosSolicitacaoEmissaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroSolicitacaoCartaoException;
import com.estudosmicroservico.msavaliadorcredito.application.service.SolicitarEmissaoCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("avaliacoes-credito")
public class SolicitarEmissaoCartaoController {

    private final SolicitarEmissaoCartaoService solicitarEmissaoCartaoService;

    @PostMapping("/solicitacoes-cartao")
    public ResponseEntity execute(@RequestBody DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao){

        try{

            ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao =
                    solicitarEmissaoCartaoService.solicitarEmissaoCartao(dadosSolicitacaoEmissaoCartao);

            return ResponseEntity.ok(protocoloSolicitacaoCartao);

        }catch (ErroSolicitacaoCartaoException e ){

            return ResponseEntity.internalServerError()
                                 .body(e.getMessage());
        }


    }


}
