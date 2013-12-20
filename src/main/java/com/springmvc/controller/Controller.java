package com.springmvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserLogin;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/auth")
public class Controller
{
	@RequestMapping(value = "/login")
	public ModelAndView login()
	{
		System.out.println("Inside Controller");
		return new ModelAndView("loginPage", "userLogin", new UserLogin());
//		return new ModelAndView("NewFile", "userLogin", new UserLogin());
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("userLogin") UserLogin userLogin)
	{
		System.out.println(userLogin.getUserName());
		System.out.println(userLogin.getPassword());
		return new ModelAndView("NewFile");
	}
}
