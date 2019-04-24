package com.carros.api.exception;

import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return error("Type Mismatch: " + ex.getMessage(),ex, status);
    }

    private ResponseEntity<Object> error(String msg,Exception ex, HttpStatus status) {
        ex.printStackTrace();
        return ResponseEntity.ok(new ResponseError("Erro", status));
    }

    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity handleException(Exception ex) {
        return ResponseEntity.ok(ResponseError.msg("Não foi possível excluir o registro: " + ex.getMessage()));
    }

}
