package com.microservices.cursoudemy.msclientes.controller;

import com.microservices.cursoudemy.msclientes.domain.ConfigDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class TesteInjecaoClasseEstatica {
    
    @GetMapping("/teste-injecao")
    public void execute() {

        ConfigDatabase instance = ConfigDatabase.getInstance();

        System.out.println(instance.getUrlDatabase());

        System.out.println(instance.getUsername());

        System.out.println(instance.getPassword());

    }

}
