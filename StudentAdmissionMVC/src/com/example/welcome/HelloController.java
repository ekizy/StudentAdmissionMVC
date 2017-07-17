package com.example.welcome;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView modelandview = new ModelAndView("HelloPage2");
		modelandview.addObject("hi", "Hi User, welcome to the first Spring MVC Application");
		modelandview.addObject("hi2","Thanks for visiting our page");

		return modelandview;
	}
}