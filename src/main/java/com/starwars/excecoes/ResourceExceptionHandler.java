package com.starwars.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErroPadrao> objectNotFound (ObjectNotFoundException e, HttpServletRequest request) {
		String erro = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao ep = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(ep);
	}
}
