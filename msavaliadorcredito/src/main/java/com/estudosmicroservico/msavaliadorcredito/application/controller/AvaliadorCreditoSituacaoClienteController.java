package com.estudosmicroservico.msavaliadorcredito.application.controller;

import com.estudosmicroservico.msavaliadorcredito.application.exception.DadosClienteNotFoundException;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroDeComunicacaoMicroservicesException;
import com.estudosmicroservico.msavaliadorcredito.application.service.ObterSituacaoClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoSituacaoClienteController {

    private final ObterSituacaoClienteService obterSituacaoClienteService;

    @GetMapping("/situacao-cliente/{cpf}")
    public ResponseEntity execute(@PathVariable String cpf) {


        try {
            SituacaoCliente response = obterSituacaoClienteService.execute(cpf);
            return ResponseEntity.ok(response);

        } catch (DadosClienteNotFoundException e) {

            return ResponseEntity.notFound()
                                 .build();

        } catch (ErroDeComunicacaoMicroservicesException e) {

            return ResponseEntity.status(HttpStatus.resolve(e.getStatus()))
                                 .body(e.getMessage());
        }

    }

}
