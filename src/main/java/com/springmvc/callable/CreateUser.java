package com.springmvc.callable;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.UserService;

public class CreateUser implements Callable<UserDetails>
{
	@Autowired
	UserService authenticationService;
	
	@Override
	public UserDetails call() throws Exception
	{
		Thread.sleep(10000);//Pausing to see the Callable - future advantage
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("Chand");
		userLogin.setPassword("password");
		return authenticationService.authenticatelogin(userLogin);		
	}

}
