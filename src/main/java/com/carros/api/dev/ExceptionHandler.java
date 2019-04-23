package com.carros.api.dev;

import com.carros.api.ResponseError;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Profile("dev")
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return error("Type Mismatch: " + ex.getMessage(),ex, status);
    }

    private ResponseEntity<Object> error(String msg,Exception ex, HttpStatus status) {
        ex.printStackTrace();
        return ResponseEntity.ok(new ResponseError(msg, status));
    }
}
