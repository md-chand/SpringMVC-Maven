package com.springmvc.services;

import com.springmvc.model.UserDetails;

/**
 * 
 * @author mpasha
 * 
 *         This interface should contain methods related CRUD operations of User
 *         only
 */
public interface UserService
{
	/**
	 * This method will create a user and return back newly created
	 * {@link UserDetails} object
	 * 
	 * @param userDetails
	 *            Object containing User details
	 * @return Newly create {@link UserDetails} object
	 */
	UserDetails createUser(UserDetails userDetails);

	/**
	 * This method will read and return {@link UserDetails} with respect to the
	 * user name sent in as parameter
	 * 
	 * @param userName
	 *            User name for which User details to be returned
	 * @return {@link UserDetails}
	 */
	UserDetails getUserByUserName(String userName);

	/**
	 * This method will read and return {@link UserDetails} with respect to the
	 * email sent in as parameter
	 * 
	 * @param email
	 *            Email of corresponding user whose user details to be returned
	 * @return {@link UserDetails}
	 */
	UserDetails getUserByEmail(String email);

	UserDetails updateUserPassword(UserDetails userDetails);
}
