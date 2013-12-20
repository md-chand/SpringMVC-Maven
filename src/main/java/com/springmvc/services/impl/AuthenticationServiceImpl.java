package com.springmvc.services.impl;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService
{

	@Override
	public UserDetails authenticatelogin(UserLogin userLogin)
	{
		UserDetails userDetails = null;
		if (userLogin.getUserName().equals("Chand") && userLogin.getPassword().equals("password"))
		{
			userDetails = new UserDetails();
		}
		return userDetails;
	}

}
