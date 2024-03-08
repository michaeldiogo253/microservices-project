package com.estudosmicroservicos.mscartoes.application.repository;

import com.estudosmicroservicos.mscartoes.application.domain.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, Long> {

    @Query("select c from ClienteCartao c where c.cpf = ?1")
    List<ClienteCartao> findByCpf(String cpf);
}
