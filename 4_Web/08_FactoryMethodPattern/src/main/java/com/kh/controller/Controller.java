package com.kh.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse responese) throws Exception;

	
	
	
	
}
