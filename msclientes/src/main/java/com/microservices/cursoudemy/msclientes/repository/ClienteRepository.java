package com.microservices.cursoudemy.msclientes.repository;

import com.microservices.cursoudemy.msclientes.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.cpf = ?1")
    Optional<Cliente> findByCpf(String cpf);
}
