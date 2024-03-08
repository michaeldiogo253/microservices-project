package com.microservices.cursoudemy.msclientes.controller;

import com.microservices.cursoudemy.msclientes.controller.request.CadastrarClienteRequest;
import com.microservices.cursoudemy.msclientes.service.CadastrarClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
public class CadastrarClienteController {

    private final CadastrarClienteService cadastrarClienteService;

    @PostMapping
    public ResponseEntity<Object> execute(@RequestBody @Valid CadastrarClienteRequest request) {

        cadastrarClienteService.salvar(request.toModel());

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                                                        .query("cpf={cpf}")
                                                        .buildAndExpand(request.getCpf())
                                                        .toUri();

        return ResponseEntity.created(headerLocation)
                             .build();
    }

}
