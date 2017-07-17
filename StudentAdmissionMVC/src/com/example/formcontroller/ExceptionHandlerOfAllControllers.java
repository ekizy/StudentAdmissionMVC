package com.example.formcontroller;

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
		System.out.println("Exception occured");
		System.out.println(e.getStackTrace().toString());

		return "Exception";
	}

}
