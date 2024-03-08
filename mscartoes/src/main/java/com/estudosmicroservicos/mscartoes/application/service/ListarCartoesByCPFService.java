package com.estudosmicroservicos.mscartoes.application.service;

import com.estudosmicroservicos.mscartoes.application.controller.response.ClienteCartaoResponse;
import com.estudosmicroservicos.mscartoes.application.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListarCartoesByCPFService {

    private final ClienteCartaoRepository clienteCartaoRepository;

    public List<ClienteCartaoResponse> execute(String cpf){


      return clienteCartaoRepository.findByCpf(cpf).stream().map(c -> new ClienteCartaoResponse(c)).collect(Collectors.toList());

    }




}
