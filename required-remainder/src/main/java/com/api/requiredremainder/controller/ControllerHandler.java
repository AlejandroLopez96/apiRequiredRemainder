package com.api.requiredremainder.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.requiredremainder.utils.ApiErrorHandler;

@RestControllerAdvice
public class ControllerHandler extends ResponseEntityExceptionHandler{

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        
        ApiErrorHandler apiError = 
        new ApiErrorHandler(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ MethodArgumentTypeMismatchException.class })
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
    MethodArgumentTypeMismatchException ex, WebRequest request) {
        String error = 
        ex.getName() + " should be of type " + ex.getRequiredType().getName();

        ApiErrorHandler apiError = 
        new ApiErrorHandler(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        return new ResponseEntity<Object>(
        apiError, new HttpHeaders(), apiError.getStatus());
    }
}
