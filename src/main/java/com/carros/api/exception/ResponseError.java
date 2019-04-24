package com.carros.api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseError {
    private String msg;
    private String stackTrace;
    private HttpStatus status;

    public ResponseError(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }

    public ResponseError(String msg) {
        this.msg = msg;
    }

    public static ResponseError msg(String msg) {
        return new ResponseError(msg);
    }
}
