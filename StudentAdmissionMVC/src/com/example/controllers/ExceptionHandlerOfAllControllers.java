package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerOfAllControllers {

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //sayfanın hatalı gözükmesi sağlandı.
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e)
	{
		System.out.println("An Exception occured");
		e.printStackTrace();

		return "Exception";
	}

}
