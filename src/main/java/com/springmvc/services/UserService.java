package com.springmvc.services;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;

/**
 * 
 * @author mpasha
 * 
 */
public interface UserService
{
	/**
	 * This method will validate user credentials
	 * 
	 * @param userLogin
	 * @return
	 */
	UserDetails authenticatelogin(UserLogin userLogin);

	UserDetails createUser(UserDetails userDetails);
}
