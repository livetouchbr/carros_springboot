package com.carros.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseError {
    private String msg;
    private HttpStatus status;
}
