package com.example.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ExampleController {

	@RequestMapping("/example")  //route'a girilen input. Ama mappinginde bu sefer dosya adi da ayni olmali.
	public ModelAndView example()
	{
		ModelAndView model = new ModelAndView("ExamplePage");
		model.addObject("message","This is an example");

		return model;
	}
}
