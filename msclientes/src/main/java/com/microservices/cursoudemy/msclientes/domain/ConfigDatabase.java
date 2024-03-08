package com.microservices.cursoudemy.msclientes.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Data
public class ConfigDatabase {

    private static ConfigDatabase selfInstance;

    @Value("${spring.datasource.url}") private String urlDatabase;

    @Value("${spring.datasource.username}") private String username;

    @Value("${spring.datasource.password}") private String password;

    @PostConstruct
    public void init() {

        selfInstance = this;
    }

    public static ConfigDatabase getInstance() {

        return selfInstance;
    }

}
