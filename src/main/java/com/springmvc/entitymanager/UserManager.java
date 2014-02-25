package com.springmvc.entitymanager;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.UserDetailsEntity;

@Repository("userRepository")
public class UserManager extends AbstractManager<UserDetailsEntity> 
{
	public UserManager() 
	{
		super(UserDetailsEntity.class);
	}
}
