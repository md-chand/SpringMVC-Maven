package com.springmvc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.model.UserDetails;
import com.springmvc.services.UserService;
import com.springmvc.utils.EntityConverter;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	UserManager userRepository;

	@Override
	@Transactional
	public UserDetails createUser(UserDetails userDetails)
	{
		UserDetailsEntity userDetailsEntity = EntityConverter.toEntity(userDetails);
		userDetailsEntity = userRepository.persist(userDetailsEntity);
		return EntityConverter.fromEntity(userDetailsEntity);
	}
}
