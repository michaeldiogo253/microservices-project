package com.estudosmicroservicos.mscartoes.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class StatusApplicationController {

    @GetMapping("/status-api")
    public ResponseEntity<Object> execute(){

        return ResponseEntity.ok().build();
    }

}
