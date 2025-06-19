package com.example.demo.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<String> handleException(RuntimeException e){
       return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
    }
}
