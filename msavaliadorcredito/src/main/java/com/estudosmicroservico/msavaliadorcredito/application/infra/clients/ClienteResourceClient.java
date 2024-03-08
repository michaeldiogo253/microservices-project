package com.estudosmicroservico.msavaliadorcredito.application.infra.clients;

import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteResourceClient {

    @GetMapping
    public ResponseEntity<DadosCliente> findDadosClientesByCpf(@RequestParam("cpf") String cpf);

}
