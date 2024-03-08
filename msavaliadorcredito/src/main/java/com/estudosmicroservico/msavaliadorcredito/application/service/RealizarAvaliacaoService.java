package com.estudosmicroservico.msavaliadorcredito.application.service;

import com.estudosmicroservico.msavaliadorcredito.application.controller.response.AvaliacaoClienteResponse;
import com.estudosmicroservico.msavaliadorcredito.application.controller.response.CartaoAprovado;
import com.estudosmicroservico.msavaliadorcredito.application.controller.response.ProtocoloSolicitacaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoResponse;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosSolicitacaoEmissaoCartao;
import com.estudosmicroservico.msavaliadorcredito.application.exception.DadosClienteNotFoundException;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroDeComunicacaoMicroservicesException;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroSolicitacaoCartaoException;
import com.estudosmicroservico.msavaliadorcredito.application.infra.clients.CartoesResourceClient;
import com.estudosmicroservico.msavaliadorcredito.application.infra.clients.ClienteResourceClient;
import com.estudosmicroservico.msavaliadorcredito.application.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.YEARS;

@RequiredArgsConstructor
@Service
public class RealizarAvaliacaoService {

    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;

    public AvaliacaoClienteResponse execute(String cpf, Long renda) throws DadosClienteNotFoundException,
                                                                           ErroDeComunicacaoMicroservicesException {

        try{

            ResponseEntity<DadosCliente> response = clienteResourceClient.findDadosClientesByCpf(cpf);

            LocalDate dataNascimento = response.getBody()
                                               .getDataNascimento();

            ResponseEntity<List<CartaoResponse>> cartoesCompativeisComRenda =
                    cartoesResourceClient.findCartoesCompativeisComRenda(renda);

            List<CartaoAprovado> cartaoAprovados = cartoesCompativeisComRenda.getBody()
                                                                     .stream()
                                                                     .map(c -> new CartaoAprovado(c.getNome(),
                                                                                                  c.getBandeira(),
                                                                                                  getLimiteAprovado(c,
                                                                                                                    dataNascimento)))
                                                                     .collect(Collectors.toList());



            return new AvaliacaoClienteResponse(cartaoAprovados);

        } catch (FeignException.FeignClientException ex){

            int status = ex.status();

            if(HttpStatus.NOT_FOUND.value() == status){
                throw new DadosClienteNotFoundException();
            }

            throw new ErroDeComunicacaoMicroservicesException(ex.getMessage(), ex.status());

        }
    }

    private BigDecimal getLimiteAprovado(CartaoResponse cartaoResponse, LocalDate dataNascimento) {

        long age = YEARS.between(dataNascimento, LocalDate.now());

        BigDecimal idade = BigDecimal.valueOf(age);

        BigDecimal fator = idade.divide(BigDecimal.TEN, RoundingMode.DOWN);

        return cartaoResponse.getLimiteBasico()
                                            .multiply(fator);


    }



}
