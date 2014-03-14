package com.springmvc.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthService;
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
	UserService userServiceImpl;

	@Autowired
	AuthService authServiceImpl;

	/** Authentication related methods */

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

	@ResponseBody
	@RequestMapping(value = "/auth/signOut", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().invalidate();
		ModelAndView model = login();
		model.addObject("error", "You have logged out successfully.");
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/forgotPassword", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView forgetPassword()
	{
		ModelAndView modelAndView = new ModelAndView("forgotPasswordPage", "userLogin", new UserLogin());
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/generateResetPasswordToken", method = RequestMethod.POST)
	public ModelAndView generateResetPasswordToken(@ModelAttribute("userLogin") UserLogin userLogin,
			HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView view = null;
		String message = "Password reset link has been sent to your registred email address. <br/>You can reset the password by clicking that link";
		try
		{
			boolean result = authServiceImpl.sendResetPasswordToken(userLogin);
			if (!result)
			{
				message = "can not process password recovery process now. Please contact Administrator";
			}
			view = new ModelAndView("showMessage");
			view.addObject("message", message);
		} catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/validateResetPasswordToken", method = RequestMethod.GET)
	public ModelAndView validateResetPasswordToken(@RequestParam("token") String token)
	{
		ModelAndView view = null;
		UserDetails userDetails = authServiceImpl.validateResetPasswordToken(token);
		if (userDetails != null)
		{
			view = new ModelAndView("resetPasswordPage", "userDetails", userDetails);
		}
		else
		{
			view = new ModelAndView("showMessage");
			view.addObject("message", "Passsword recovery token is invalid.");
		}
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(@ModelAttribute("userDetails") UserDetails userDetails,
			HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView view = null;
		try
		{
			userDetails = userServiceImpl.updateUserPassword(userDetails);
			if (userDetails != null)
			{
				request.getSession().setAttribute("LOGGEDIN_USER", userDetails);
				view = new ModelAndView("userHome");
			}
		} catch (Exception exception)
		{
			view = new ModelAndView("loginPage", "userLogin", new UserLogin());
			view.addObject("error", exception.getMessage());
		}
		return view;
	}

	/** User Operations related methods */
	@RequestMapping(value = "/auth/getCreateUserPage")
	public ModelAndView getCreateUserPage(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("createUserPage", "userDetails", new UserDetails());
	}

	@RequestMapping(value = "/auth/createUser", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("userDetails") UserDetails userDetails, HttpServletRequest request,
			HttpServletResponse response)
	{
		UserDetails details = userServiceImpl.createUser(userDetails);
		if (details != null)
		{
			System.out.println("User Created Successfully.");
		}
		return new ModelAndView("userHome");
	}

	@ResponseBody
	@RequestMapping(value = "/auth/userHomePage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userHomePage(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("userHome");
	}

	@ResponseBody
	@RequestMapping(value = "/userNameAvailable", method = RequestMethod.GET)
	public String isUserNameAvailable(@RequestParam("userName") String userName)
	{
		String result = "valid";
		UserDetails userDetails = userServiceImpl.getUserByUserName(userName);
		if (userDetails != null)
		{
			result = "invalid";
		}
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/emailExistence", method = RequestMethod.GET)
	public String isEmailExisted(@RequestParam("emailId") String emailId)
	{
		String result = "not existed";
		UserDetails userDetails = userServiceImpl.getUserByEmail(emailId);
		if (userDetails != null)
		{
			result = "existed";
		}
		return result;
	}

	/**
	 * This method will log the error message, set the error code and error
	 * message to the response object
	 * 
	 * @param message
	 * @param response
	 * @return ModelAndView
	 */
	/*
	 * private ModelAndView getErrorResponse(Exception exception,
	 * HttpServletResponse response) { // LOGGER.error(exception.getMessage(),
	 * exception); response.setStatus(500); // ModelAndView model = new
	 * ModelAndView(createUpdateProjectErrorPage); ModelAndView model = new
	 * ModelAndView(""); String errorMessage = exception.getMessage();
	 * model.addObject("errorMessage", errorMessage); return model; }
	 */
}
