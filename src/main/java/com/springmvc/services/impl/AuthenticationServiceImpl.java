package com.springmvc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.UserService;
import com.springmvc.utils.EntityConverter;

@Service
public class AuthenticationServiceImpl implements UserService
{

	@Autowired
	public UserManager userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails authenticatelogin(UserLogin userLogin)
	{
		UserDetails userDetails = null;
		List<UserDetailsEntity> userList = userRepository.validateUser(userLogin);
		if (!userList.isEmpty())
		{
			UserDetailsEntity userDetailsEntity = userList.get(0);
			userDetails = EntityConverter.fromEntity(userDetailsEntity);
		}
		return userDetails;
	}

	@Override
	@Transactional
	public UserDetails createUser(UserDetails userDetails)
	{
		UserDetailsEntity userDetailsEntity = EntityConverter.toEntity(userDetails);
		userDetailsEntity = userRepository.persist(userDetailsEntity);
		return EntityConverter.fromEntity(userDetailsEntity);
	}
}
