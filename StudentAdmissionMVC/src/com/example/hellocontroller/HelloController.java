package com.example.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController {

	@RequestMapping("/welcome") //write whatever you want
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","hello world");

		return model;
	}

	@RequestMapping("/hi")
	public ModelAndView hiWorld() {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","hi world");

		return model;
	}
	@RequestMapping("/one/{userName}")  //We can add path variables as inputs to the modelandview. They can be more than one.
	public ModelAndView userHi(@PathVariable("userName")String name) {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","hi "+name+" Welcome to the our first spring project" );

		return model;
	}
	@RequestMapping("/multiple/{userName}/{countryName}")  //We can add path variables as inputs to the modelandview. They can be more than one.
	public ModelAndView userCountryHi(@PathVariable Map <String,String> pathVariables) {

		String name = pathVariables.get("userName");
		String country=pathVariables.get("countryName");

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg","Hi "+name+". You are from "+country);

		return model;
	}

}
/*public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("hi", "Hi User, welcome to the first Spring MVC Application");
		modelandview.addObject("hi2","Thanks for visiting our page");

		return modelandview;
	}
}*/