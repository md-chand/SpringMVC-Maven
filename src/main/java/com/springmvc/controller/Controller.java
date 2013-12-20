package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/auth")
public class Controller
{
	@RequestMapping(value = "/login")
	public ModelAndView login() 
	{
		System.out.println("Inside Controller");
		return new ModelAndView("NewFile");
	}
}
