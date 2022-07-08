package com.spring_desafio.handler;

import com.spring_desafio.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionGenericsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(Exception ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Not found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerClientAlreadyExistsException(Exception ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title("Client already exists!")
                        .status(HttpStatus.CONFLICT.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(CannotBeNullException.class)
    public ResponseEntity<ExceptionDetails> handlerInternalServerError(CannotBeNullException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Field cannot be null")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidServerException.class)
    public ResponseEntity<ExceptionDetails> handlerInternalServerError(InvalidServerException ex) {
        return new ResponseEntity<ExceptionDetails>(
                ExceptionDetails.builder()
                        .title("Internal server error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
