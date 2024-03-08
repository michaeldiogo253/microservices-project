package com.estudosmicroservico.msavaliadorcredito.application.controller;

import com.estudosmicroservico.msavaliadorcredito.application.controller.request.AvaliacaoRequest;
import com.estudosmicroservico.msavaliadorcredito.application.controller.response.AvaliacaoClienteResponse;
import com.estudosmicroservico.msavaliadorcredito.application.exception.DadosClienteNotFoundException;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroDeComunicacaoMicroservicesException;
import com.estudosmicroservico.msavaliadorcredito.application.service.RealizarAvaliacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("avaliacoes-credito")
public class RealizarAvaliacaoController {


    private final RealizarAvaliacaoService realizarAvaliacaoService;

    @PostMapping("/realizar-avaliacao")
    public ResponseEntity execute(@RequestBody AvaliacaoRequest request){

        try {
            AvaliacaoClienteResponse response =
                    realizarAvaliacaoService.execute(request.getCpf(), request.getRenda());

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
