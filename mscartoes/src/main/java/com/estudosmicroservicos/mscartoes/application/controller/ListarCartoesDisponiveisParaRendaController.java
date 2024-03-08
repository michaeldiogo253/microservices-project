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

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class ListarCartoesDisponiveisParaRendaController {

    private final CartaoRepository cartaoRepository;

    @GetMapping("/listar-compativeis-com-renda/{valorRenda}")
    public ResponseEntity<List<CartaoResponse>> execute(@PathVariable Long valorRenda) {

        List<Cartao> cartoes = cartaoRepository.findByRendaLessThanEqual(BigDecimal.valueOf(valorRenda));

        List<CartaoResponse> cartoesResponse = cartoes.stream()
                                                      .map(CartaoResponse::new)
                                                      .collect(Collectors.toList());

        return ResponseEntity.ok(cartoesResponse);
    }

}
