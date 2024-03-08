package com.estudosmicroservicos.mscartoes.application.controller;

import com.estudosmicroservicos.mscartoes.application.controller.response.ClienteCartaoResponse;
import com.estudosmicroservicos.mscartoes.application.service.ListarCartoesByCPFService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class ListarCartoesByCPFController {

    private final ListarCartoesByCPFService listarCartoesByCPFService;

    @GetMapping("/by-cliente/{cpf}")
    public ResponseEntity<List<ClienteCartaoResponse>> execute(@PathVariable String cpf) {

        listarCartoesByCPFService.execute(cpf);

        return ResponseEntity.ok(listarCartoesByCPFService.execute(cpf));
    }
}
