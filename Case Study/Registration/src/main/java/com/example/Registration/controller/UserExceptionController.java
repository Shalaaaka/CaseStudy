package com.example.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Registration.exception.UserAlreadyExistsException;

@ControllerAdvice
public class UserExceptionController 
{
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity<Object> exception(UserAlreadyExistsException exception)
	{
		return new ResponseEntity<>("User Already Exists",HttpStatus.BAD_REQUEST);
	}
}
