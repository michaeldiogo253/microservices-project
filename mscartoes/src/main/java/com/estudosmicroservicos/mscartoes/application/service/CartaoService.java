package com.estudosmicroservicos.mscartoes.application.service;

import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import com.estudosmicroservicos.mscartoes.application.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    @Transactional
    public Cartao salvar(Cartao cartao) {

        return cartaoRepository.save(cartao);

    }


}
