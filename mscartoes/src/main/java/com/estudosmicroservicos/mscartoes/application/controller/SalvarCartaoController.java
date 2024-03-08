package com.estudosmicroservicos.mscartoes.application.controller;

import com.estudosmicroservicos.mscartoes.application.controller.request.CadastrarCartaoRequest;
import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import com.estudosmicroservicos.mscartoes.application.service.CartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class SalvarCartaoController {

    private final CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<Object> execute(@RequestBody @Valid CadastrarCartaoRequest request) {

        Cartao cartao = cartaoService.salvar(request.toModel());

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                                                        .path("/"+ cartao.getId()).build()
                                                        .toUri();

        return ResponseEntity.created(headerLocation)
                             .build();
    }


}
