package com.example.demo_validate_api.advice_controller;

import com.example.demo_validate_api.model.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ProductAdviceController {
    public ProductAdviceController() {
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse<Map<String, String>>> handleMethodArgument(MethodArgumentNotValidException ex){
            Map<String,String> map = new HashMap<>();
            ex.getFieldErrors().stream().forEach(err -> map.put(err.getField(),err.getDefaultMessage()));
            return  new ResponseEntity<>(new ErrorResponse<>("Error!",map, HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse<String>> handNoSuchElement(NoSuchElementException ex){
        return new ResponseEntity<>(new ErrorResponse<>("Error",ex.getLocalizedMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}
