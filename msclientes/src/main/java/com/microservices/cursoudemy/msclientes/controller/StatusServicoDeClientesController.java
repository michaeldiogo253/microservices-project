package com.microservices.cursoudemy.msclientes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("clientes")
public class StatusServicoDeClientesController {

    @GetMapping("/status-api")
    public ResponseEntity<Object> execute(){

        return ResponseEntity.ok().build();
    }

}
