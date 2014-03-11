package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthService;
import com.springmvc.services.CallableFutureService;
import com.springmvc.services.UserService;

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
	AuthService authServiceImpl;

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
		UserDetails userDetails = authServiceImpl.login(userLogin);
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
	public ModelAndView getCreateUserPage(HttpServletRequest request, HttpServletResponse response)
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
	public String createUsers(HttpServletRequest request, HttpServletResponse response)
	{
		callableFutureService.createUserExecutor();
		return "processing request!";
	}

	@ResponseBody
	@RequestMapping(value = "/auth/userHomePage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userHomePage(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("userHome");
	}

	@ResponseBody
	@RequestMapping(value = "/auth/signOut", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().invalidate();
		ModelAndView model = login();
		model.addObject("error", "You have logged out successfully.");
		return model;
	}
}
