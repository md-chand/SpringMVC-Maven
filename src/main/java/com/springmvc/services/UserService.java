package com.springmvc.services;

import com.springmvc.model.UserDetails;

/**
 * 
 * @author mpasha
 * 
 */
public interface UserService
{
	UserDetails createUser(UserDetails userDetails);

	UserDetails getUserByUserName(String userName);

	UserDetails getUserByEmail(String email);
	
	UserDetails updateUserPassword(UserDetails userDetails);
}
