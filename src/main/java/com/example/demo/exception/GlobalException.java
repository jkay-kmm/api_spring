package com.example.demo.exception;
import com.example.demo.dto.request.ApiReponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = Exception.class)
     ResponseEntity<ApiReponse> handleExceptionException(Exception e){
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setMessage(e.getMessage());
        apiReponse.setCode(1001);
       return ResponseEntity.badRequest().body(apiReponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiReponse> handleAppExceptionException(AppException e){
        ErrorCode errorCode = e.getErrorCode();
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setMessage(errorCode.getMessage());
        apiReponse.setCode(errorCode.getCode());
        return ResponseEntity.badRequest().body(apiReponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiReponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String enumkey = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumkey);
        ApiReponse apiReponse = new ApiReponse();
        apiReponse.setMessage(errorCode.getMessage());
        apiReponse.setCode(errorCode.getCode());

        return ResponseEntity.badRequest().body(apiReponse);
    }
}
