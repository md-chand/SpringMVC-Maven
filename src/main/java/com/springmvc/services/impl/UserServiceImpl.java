package com.springmvc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.exception.InvalidUserException;
import com.springmvc.model.UserDetails;
import com.springmvc.services.UserService;
import com.springmvc.utils.EntityConverter;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserManager userManager;

	@Override
	@Transactional
	public UserDetails createUser(UserDetails userDetails)
	{
		UserDetailsEntity userDetailsEntity = EntityConverter.toEntity(userDetails);
		userDetailsEntity = userManager.persist(userDetailsEntity);
		return EntityConverter.fromEntity(userDetailsEntity);
	}

	@Override
	public UserDetails getUserByUserName(String userName)
	{
		UserDetails userDetails = null;
		List<UserDetailsEntity> userList = userManager.getUserByUserName(userName);
		if (userList.size() > 0)
		{
			userDetails = EntityConverter.fromEntity(userList.get(0));
		}
		return userDetails;
	}

	@Override
	public UserDetails getUserByEmail(String email)
	{
		UserDetails userDetails = null;
		List<UserDetailsEntity> userList = userManager.getUserByEmail(email);
		if (userList.size() > 0)
		{
			userDetails = EntityConverter.fromEntity(userList.get(0));
		}
		return userDetails;
	}

	@Override
	@Transactional
	public UserDetails updateUserPassword(UserDetails userDetails)
	{
		UserDetailsEntity userDetailsEntity = userManager.findById(userDetails.getUserId());
		if (userDetailsEntity == null)
		{
			throw new InvalidUserException("No user exist with id:" + userDetails.getUserId());
		}
		userDetailsEntity.setPassword(userDetails.getPassword());
		userDetailsEntity = userManager.merge(userDetailsEntity);
		return EntityConverter.fromEntity(userDetailsEntity);
	}

}
