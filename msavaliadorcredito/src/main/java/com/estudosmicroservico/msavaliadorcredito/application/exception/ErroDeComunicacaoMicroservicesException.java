package com.estudosmicroservico.msavaliadorcredito.application.exception;

import lombok.Getter;

public class ErroDeComunicacaoMicroservicesException extends Exception {

    @Getter private Integer status;

    public ErroDeComunicacaoMicroservicesException(String message, Integer status) {

        super(message);
        this.status = status;
    }
}
