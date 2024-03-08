package com.microservices.cursoudemy.msclientes.service;

import com.microservices.cursoudemy.msclientes.domain.Cliente;
import com.microservices.cursoudemy.msclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CadastrarClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {

       return clienteRepository.save(cliente);

    }
}
