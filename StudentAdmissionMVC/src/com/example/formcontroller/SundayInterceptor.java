package com.example.formcontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SundayInterceptor extends HandlerInterceptorAdapter{

	//Prehandle methodu uygulamanın requesti handle edip etmeyeceğini kontrol eder.
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,Object handler) throws IOException
	{
		Calendar cal =Calendar.getInstance();

		int dayOfWeek =cal.get(cal.DAY_OF_WEEK);

		//Gunler Pazardan Pazartesiye kadar 1-7 şeklinde gider.

		if(dayOfWeek ==1)
		{
			response.getWriter().write("The website does not work on Sunday. Please try another day");
			return false;
		}
		else return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object hnadler,
			ModelAndView model) throws Exception
	{
		//bu method spring kullanıcıdan gelen requesti handle ettikten sonra çağrılır.
		System.out.println("HandlerInterceptorAdapter calls postHandle method for "+ request.getRequestURI());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,
			Exception ex) throws Exception
	{
		System.out.println("HandlerInterceptorAdapter calls afterCompletion method for "+ request.getRequestURI());
		//Bu method ise response sayfaya yansıtıldıktan sonra çağrılır.
	}
}
