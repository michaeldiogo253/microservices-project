package com.estudosmicroservico.msavaliadorcredito.application.service;

import com.estudosmicroservico.msavaliadorcredito.application.controller.SituacaoCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.CartaoCliente;
import com.estudosmicroservico.msavaliadorcredito.application.domain.DadosCliente;
import com.estudosmicroservico.msavaliadorcredito.application.exception.DadosClienteNotFoundException;
import com.estudosmicroservico.msavaliadorcredito.application.exception.ErroDeComunicacaoMicroservicesException;
import com.estudosmicroservico.msavaliadorcredito.application.infra.clients.CartoesResourceClient;
import com.estudosmicroservico.msavaliadorcredito.application.infra.clients.ClienteResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ObterSituacaoClienteService {

    private final ClienteResourceClient clienteResourceClient;
    private final CartoesResourceClient cartoesResourceClient;

    public SituacaoCliente execute(String cpf) throws DadosClienteNotFoundException,
                                                      ErroDeComunicacaoMicroservicesException {

        try{

            ResponseEntity<DadosCliente> response = clienteResourceClient.findDadosClientesByCpf(cpf);

            ResponseEntity<List<CartaoCliente>> cartoes = cartoesResourceClient.findCartoesByCpf(cpf);

            return SituacaoCliente.builder()
                                  .cliente(response.getBody())
                                  .cartoes(cartoes.getBody())
                                  .build();

        } catch (FeignException.FeignClientException ex){

            int status = ex.status();

            if(HttpStatus.NOT_FOUND.value() == status){
                throw new DadosClienteNotFoundException();
            }

            throw new ErroDeComunicacaoMicroservicesException(ex.getMessage(), ex.status());

        }






    }

}
