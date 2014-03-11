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
	AuthService authService;

	@Test
	public void test()
	{
		System.out.println("Hello world");
		Assert.assertNotNull(authService);
		UserLogin userLogin = new UserLogin();
		userLogin.setUserName("admin");
		userLogin.setPassword("admin");
		UserDetails userDetails = authService.login(userLogin);
		Assert.assertNotNull(userDetails);
		Assert.assertNotNull(userDetails.getUserId());
		System.out.println("#### " + userDetails.getUserId());
	}

}
