package com.example.Stores.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Stores.Exceptiom.AlreadyExistsException;

@ControllerAdvice
public class ExceptionController 
{
	@ExceptionHandler(value=AlreadyExistsException.class)
	public ResponseEntity<Object> exception(AlreadyExistsException exception)
	{
		return new ResponseEntity<>("Already Exists",HttpStatus.BAD_REQUEST);
	}	
}