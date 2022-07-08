package com.spring_desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ClientAlreadyExistsException extends RuntimeException {
    public ClientAlreadyExistsException(String message){
        super(message);
    }
}
