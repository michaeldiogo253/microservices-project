package com.estudosmicroservicos.mscartoes.application.controller;

import com.estudosmicroservicos.mscartoes.application.controller.response.CartaoResponse;
import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import com.estudosmicroservicos.mscartoes.application.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class ListarCartaoPorIdController {

    private final CartaoRepository cartaoRepository;

    @GetMapping("/{idCartao}")
    public ResponseEntity execute(@PathVariable Long idCartao){

        Optional<Cartao> cartao = cartaoRepository.findById(idCartao);

        if(cartao.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new CartaoResponse(cartao.get()));
    }


}
