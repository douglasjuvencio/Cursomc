package com.example.demo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javassist.tools.rmi.ObjectNotFoundException;

@ControllerAdvice

public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e , HttpServerErrorException request){
		StandardError err  = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err)	;	
	}
	

}
