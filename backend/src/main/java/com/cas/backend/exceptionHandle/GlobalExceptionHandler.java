package com.cas.backend.exceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), "Bad Request", "유효성 검사 실패", path, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage(),path);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        ex.printStackTrace(); // 로깅 권장
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", "서버 오류 발생", path);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}