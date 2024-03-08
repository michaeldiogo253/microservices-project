package com.microservices.cursoudemy.msclientes.controller;

import com.microservices.cursoudemy.msclientes.controller.response.ClienteResponse;
import com.microservices.cursoudemy.msclientes.domain.Cliente;
import com.microservices.cursoudemy.msclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("clientes")
public class BuscarClientePorCpfController {


    private final ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity execute(@RequestParam("cpf") String cpf){

        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);

        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ClienteResponse.of(cliente.get()));
    }

}
