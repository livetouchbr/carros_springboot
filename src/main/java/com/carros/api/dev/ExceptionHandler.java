package com.carros.api.dev;

import com.carros.api.ResponseError;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Profile("dev")
public class ExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

    /**
     * Provides handling for standard Spring MVC exceptions.
     * @param ex the target exception
     * @param request the current request
     */
    @org.springframework.web.bind.annotation.ExceptionHandler({
            Exception.class
    })
    @Nullable
    public final ResponseEntity<Object> handleException(Exception ex, WebRequest request) throws Exception {
        if(ex instanceof NullPointerException) {
            return error("Erro na API: " + ex.getMessage(),ex, HttpStatus.BAD_REQUEST);
        }
        return error("Erro generico: " + ex.getMessage(),ex, HttpStatus.OK);
    }

//    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return error("Type Mismatch: " + ex.getMessage(),ex, status);
    }

    private ResponseEntity<Object> error(String msg,Exception ex, HttpStatus status) {
        ex.printStackTrace();
        return ResponseEntity.ok(new ResponseError(msg, status));
    }
}
