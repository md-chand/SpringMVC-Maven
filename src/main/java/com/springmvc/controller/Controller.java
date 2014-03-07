package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.UserService;
import com.springmvc.services.CallableFutureService;

/**
 * 
 * @author mpasha
 * 
 */
@org.springframework.stereotype.Controller
@RequestMapping(value = "/application")
public class Controller
{

	@Autowired
	UserService authenticationService;

	@Autowired
	CallableFutureService callableFutureService;

	@RequestMapping(value = "/login")
	public ModelAndView login()
	{
		return new ModelAndView("loginPage", "userLogin", new UserLogin());
	}

	@RequestMapping(value = "/sessionExpired")
	public ModelAndView redirectOnSessionExpiry()
	{
		ModelAndView model = login();
		model.addObject("error", "Your session has expired. Please login againg");
		return model;
	}
	
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request,
			HttpServletResponse response)
	{
		UserDetails userDetails = authenticationService.authenticatelogin(userLogin);
		if (userDetails != null)
		{
			request.getSession().setAttribute("LOGGEDIN_USER", userDetails);
			return new ModelAndView("userHome");
		}
		else
		{
			ModelAndView model = new ModelAndView("loginPage", "userLogin", new UserLogin());
			model.addObject("error", "Invalid Credentials");
			return model;
		}
	}

	@RequestMapping(value = "/auth/getCreateUserPage")
	public ModelAndView getCreateUserPage(HttpServletRequest request,
			HttpServletResponse response)
	{
		return new ModelAndView("createUserPage", "userDetails", new UserDetails());
	}

	@RequestMapping(value = "/auth/createUser", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("userDetails") UserDetails userDetails, HttpServletRequest request,
			HttpServletResponse response)
	{
		UserDetails details = authenticationService.createUser(userDetails);
		if (details != null)
		{
			System.out.println("User Created Successfully.");
		}
		return new ModelAndView("userHome");
	}

	@ResponseBody
	@RequestMapping(value = "/auth/createUsers", method = RequestMethod.GET)
	public String createUsers(HttpServletRequest request,
			HttpServletResponse response)
	{
		callableFutureService.createUserExecutor();
		return "processing request!";
	}

}
