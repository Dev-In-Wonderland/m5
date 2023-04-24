package com.mvc_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage() + " MyExceptionHandler!", HttpStatus.NOT_FOUND);
	}

	
}
