package com.estudosmicroservico.msavaliadorcredito.application.infra.clients;

import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {

    @GetMapping("/by-cliente/{cpf}")
    public ResponseEntity<List<CartaoCliente>> findCartoesByCpf(@PathVariable String cpf);

    @GetMapping("/listar-compativeis-com-renda/{valorRenda}")
    public ResponseEntity<List<CartaoResponse>> findCartoesCompativeisComRenda(@PathVariable Long valorRenda);

}
