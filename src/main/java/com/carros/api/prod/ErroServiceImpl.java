package com.carros.api.prod;

import com.carros.api.ErroService;
import com.carros.api.exception.ResponseError;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ErroServiceImpl implements ErroService {
    public ResponseEntity<Object> error(String msg, Exception ex, HttpStatus status) {
        ex.printStackTrace();
        return ResponseEntity.ok(new ResponseError("@PROD > " + msg, status));
    }
}
