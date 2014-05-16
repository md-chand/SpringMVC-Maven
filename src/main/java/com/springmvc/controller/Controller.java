package com.springmvc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.exception.InvalidUserException;
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
	public ModelAndView getLoginPage()
	{
		return new ModelAndView("loginPage", "userLogin", new UserLogin());
	}

	@RequestMapping(value = "/sessionExpired")
	public ModelAndView redirectOnSessionExpiry()
	{
		ModelAndView model = getLoginPage();
		model.addObject("error", "Your session has expired. Please login againg");
		return model;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request,
			HttpServletResponse response)
	{
		ModelAndView model = null;
		UserDetails userDetails = authServiceImpl.login(userLogin);
		if (userDetails != null)
		{
			request.getSession().setAttribute("LOGGEDIN_USER", userDetails);
			model = new ModelAndView("userHome");			
		}
		else
		{
			model = new ModelAndView("loginPage", "userLogin", new UserLogin());
			model.addObject("error", "Invalid Credentials");
		}
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/auth/signOut", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().invalidate();
		ModelAndView model = getLoginPage();
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
			HttpServletRequest request, HttpServletResponse response) throws InvalidUserException, IOException // TODO
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
		try
		{
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
		} catch (Exception exception)
		{
			view = new ModelAndView("showMessage");
			view.addObject("message", exception.getMessage());
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
			// Read user name and add it to input model
			userDetails = userServiceImpl.updateUserPassword(userDetails);
			if (userDetails != null)
			{
				int deleteTokenState = authServiceImpl.deleteResetPasswordToken(userDetails.getUserId());
				System.err.println(deleteTokenState);
				request.getSession().setAttribute("LOGGEDIN_USER", userDetails);
				view = new ModelAndView("userHome");
				view.addObject("message", "Password reset done successfully.");
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
	public ModelAndView createUser(@ModelAttribute("userDetails") UserDetails userDetails,
			@RequestParam(value = "avatarImg", required = false) MultipartFile avatarImg, HttpServletRequest request,
			HttpServletResponse response) throws IOException// TODO
	{
		ModelAndView model = null;
		if (avatarImg != null && avatarImg.getBytes().length > 0)
		{
			userDetails.setAvatar(avatarImg.getBytes());
		}
		UserDetails details = userServiceImpl.createUser(userDetails);
		if (details != null)
		{
			model = new ModelAndView("userHome");
			model.addObject("message", "User created successfully.");
		}
		return model;
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

	@RequestMapping(value = "/auth/getAvatar/{userName}/{time}", method = RequestMethod.GET)
	public void renderPhoto(@PathVariable("userName") String userName, @PathVariable("time") long time,  HttpServletRequest request,
			HttpServletResponse response) throws IOException
	{
		UserDetails userDetails = userServiceImpl.getUserByUserName(userName);
		byte[] photo = null;
		if (userDetails.getAvatar() != null && userDetails.getAvatar().length > 0)
		{
			photo = userDetails.getAvatar();
		}
		else
		{
			String defaultAvatar = "/images/femaleProfilePic.png";
			if (userDetails.getGender().equals("Male"))
			{
				defaultAvatar = "/images/maleProfilePic.png";
			}

			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(defaultAvatar);
			photo = IOUtils.toByteArray(inputStream);
		}
		response.setContentType("image/jpeg");
		response.setContentLength(photo.length);
		response.getOutputStream().write(photo);
		response.getOutputStream().flush();
	}

	@RequestMapping(value = "/auth/updateAvatar", method = RequestMethod.POST)
	public ModelAndView updateAvatar(@RequestParam(value = "avatarImg", required = false) MultipartFile avatarImg,
			@RequestParam(value = "userName", required = false) String userName, HttpServletRequest request,
			HttpServletResponse response) throws IOException  //TODO :  Create separate service to update profile picture instead of calling update user details.
	{
		if (avatarImg.getBytes().length > 0)
		{
			userServiceImpl.updateUserDetails(userName, avatarImg.getBytes());
		}
		ModelAndView model = new ModelAndView("userHome");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/getAllUserNames", method = RequestMethod.GET)
	public ModelAndView getAllUserNames()
	{
		ModelAndView modelAndView = new ModelAndView("allUserNames");
		List<UserDetails> userDetailsList = userServiceImpl.getAllUsers();
		modelAndView.addObject("userDetailsList", userDetailsList);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/getUserDetails/{userId}", method = RequestMethod.GET)
	public ModelAndView getAllUserNames(@PathVariable ("userId") long userId)
	{
		ModelAndView modelAndView = new ModelAndView("ajaxview/userDetails");
		UserDetails userDetails = userServiceImpl.getUserByUserId(userId);
		modelAndView.addObject("userDetails", userDetails);
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/changePassword", method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("changePassword", "userDetails", new UserDetails());		
		return model;
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
