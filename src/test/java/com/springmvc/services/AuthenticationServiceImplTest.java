package com.springmvc.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/test-application-config.xml")
public class AuthenticationServiceImplTest
{	
	@Autowired
	AuthenticationService authenticationService;
	
	@Test
	public void test()
	{
		System.out.println("Hello world");
		Assert.assertNotNull(authenticationService);
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("Chand");
		userLogin.setPassword("password");
		UserDetails userDetails = authenticationService.authenticatelogin(userLogin);
		Assert.assertNotNull(userDetails);
		Assert.assertNotNull(userDetails.getUserId());
		System.out.println("#### " + userDetails.getUserId());
	}

}
