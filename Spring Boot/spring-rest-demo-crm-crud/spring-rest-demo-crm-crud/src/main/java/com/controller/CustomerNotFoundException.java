package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFoundException(String message) {
		super(message);
	}
	public CustomerNotFoundException(Throwable cause) {
		super(cause);
	}
	  public ResponseEntity<Object> buildResponse(String mes){
	        Map<String, Object> response = new HashMap<>();
	        response.put("status_code", HttpStatus.NOT_FOUND.value());
	        response.put("message", mes);
	        response.put("errors", "NotFound!");
	        response.put("status", false);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
}
