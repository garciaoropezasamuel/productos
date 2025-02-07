package com.example.productos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String>  handleRuntimeException(RuntimeException e) {
		return ResponseEntity.internalServerError().body("Error : " + e.getMessage());
	}

}