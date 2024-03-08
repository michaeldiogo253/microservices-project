package com.estudosmicroservicos.mscartoes.application.infra.mqueue;

import com.estudosmicroservicos.mscartoes.application.domain.Cartao;
import com.estudosmicroservicos.mscartoes.application.domain.ClienteCartao;
import com.estudosmicroservicos.mscartoes.application.domain.DadosSolicitacaoEmissaoCartao;
import com.estudosmicroservicos.mscartoes.application.repository.CartaoRepository;
import com.estudosmicroservicos.mscartoes.application.repository.ClienteCartaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {

    private final ObjectMapper mapper;
    private final CartaoRepository cartaoRepository;
    private final ClienteCartaoRepository clienteCartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload String payload) {

        try {

            DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao =
                    mapper.readValue(payload, DadosSolicitacaoEmissaoCartao.class);

            Cartao cartao = getCartao(dadosSolicitacaoEmissaoCartao);

            ClienteCartao clienteCartao = new ClienteCartao(dadosSolicitacaoEmissaoCartao.getCpf(),
                                                            cartao,
                                                            dadosSolicitacaoEmissaoCartao.getLimiteLiberado());

            clienteCartaoRepository.save(clienteCartao);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(payload);

    }

    private Cartao getCartao(DadosSolicitacaoEmissaoCartao dadosSolicitacaoEmissaoCartao) {

        return cartaoRepository.findById(dadosSolicitacaoEmissaoCartao.getIdCartao())
                               .orElseThrow(() -> new NoSuchElementException("Nao foi encontrado cartao com ID " +
                                                                             dadosSolicitacaoEmissaoCartao.getIdCartao()));
    }

}
