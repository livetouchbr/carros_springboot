package com.carros.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ErroService {
    ResponseEntity<Object> error(String msg, Exception ex, HttpStatus status);
}
