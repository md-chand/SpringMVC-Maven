package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthenticationService;
import com.springmvc.services.CallableFutureService;

/**
 * 
 * @author mpasha
 * 
 */
@org.springframework.stereotype.Controller
@RequestMapping(value = "/auth")
public class Controller
{

	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	CallableFutureService callableFutureService;

	@RequestMapping(value = "/login")
	public ModelAndView login()
	{
		return new ModelAndView("loginPage", "userLogin", new UserLogin());
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("userLogin") UserLogin userLogin)
	{
		System.out.println(userLogin.getUserName());
		System.out.println(userLogin.getPassword());
		UserDetails userDetails = authenticationService.authenticatelogin(userLogin);
		System.out.println(userLogin.getUserName());
		if (userDetails != null)
		{
			return new ModelAndView("userHome");
		}
		return null;
	}

	@ResponseBody
	@RequestMapping(value = "/createUsers", method = RequestMethod.GET)
	public String createUsers()
	{
		callableFutureService.createUserExecutor();
		return "processing request!";
	}
	
}
