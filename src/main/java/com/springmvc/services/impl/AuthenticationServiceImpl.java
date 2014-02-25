package com.springmvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService
{

	@Autowired
	public UserManager userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails authenticatelogin(UserLogin userLogin)
	{
		UserDetails userDetails = null;
		System.out.println("Inside Auth Service");
		if (userLogin.getUserName().equals("Chand") && userLogin.getPassword().equals("password"))
		{
			userDetails = new UserDetails();
			UserDetailsEntity detailsEntity = new UserDetailsEntity();
			detailsEntity.setName("Mohammed");
			detailsEntity.setEmail("md.pasha@compugain.com");
			detailsEntity.setContactNumber("9985947303");
			detailsEntity = userRepository.persist(detailsEntity);
			System.out.println(detailsEntity.getUserId());
			userDetails.setUserId(detailsEntity.getUserId());
		}
		return userDetails;
	}
}
