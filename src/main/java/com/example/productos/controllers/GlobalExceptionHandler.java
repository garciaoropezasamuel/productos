package com.example.productos.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Clase para manejar excepciones globales
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// metodo que se ejecuta en caso de que ocurriera alguna excepcion global
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String>  handleRuntimeException(RuntimeException e) {
		return ResponseEntity.internalServerError().body("Error : " + e.getMessage());
	}

}