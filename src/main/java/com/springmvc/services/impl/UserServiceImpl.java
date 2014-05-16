package com.springmvc.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.exception.InvalidUserException;
import com.springmvc.model.UserDetails;
import com.springmvc.services.MailService;
import com.springmvc.services.UserService;
import com.springmvc.utils.EntityConverter;
import com.springmvc.utils.PasswordHelper;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserManager userManager;

	@Autowired
	MailService mailServiceImpl;

	@Override
	@Transactional
	public UserDetails createUser(UserDetails userDetails) throws IOException
	{
		UserDetailsEntity userDetailsEntity = EntityConverter.toEntity(userDetails);
		String passwordSalt = PasswordHelper.getDefaultPassword();
		userDetailsEntity.setPassword(PasswordHelper.encodePassword(passwordSalt, userDetails.getUserName()));
		userDetailsEntity = userManager.persist(userDetailsEntity);
		mailServiceImpl.sendLoginCredentialsToUser(userDetails.getEmail(), userDetails.getUserName(), passwordSalt);
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
		String encodedPassword = PasswordHelper.encodePassword(userDetails.getPassword(), userDetails.getUserName());
		userDetailsEntity.setPassword(encodedPassword);
		userDetailsEntity = userManager.merge(userDetailsEntity);
		return EntityConverter.fromEntity(userDetailsEntity);
	}

	@Override
	@Transactional
	public UserDetails updateUserDetails(String userName, byte[] avatarBytes) throws IOException
	{
		UserDetails userDetails = null;
		List<UserDetailsEntity> userDetailsEntityList = userManager.getUserByUserName(userName);
		if (userDetailsEntityList.size() > 0)
		{
			UserDetailsEntity userDetailsEntity = userDetailsEntityList.get(0);
			userDetailsEntity.setAvatar(avatarBytes);
			userDetailsEntity.setName("New Name");
			userDetails = EntityConverter.fromEntity(userManager.merge(userDetailsEntity));
		}
		return userDetails;
	}

	@Override
	public UserDetails getUserByUserId(long userId)
	{
		return EntityConverter.fromEntity(userManager.findById(userId));
	}

	@Override
	public List<UserDetails> getAllUsers()
	{
		List<UserDetails> userDetailsList = new ArrayList<UserDetails>();
		List<UserDetailsEntity> userDetailsEntityList = userManager.getAllUser();
		for (UserDetailsEntity userDetailsEntity : userDetailsEntityList)
		{
			userDetailsList.add(EntityConverter.fromEntity(userDetailsEntity));
		}
		return userDetailsList;
	}

}
