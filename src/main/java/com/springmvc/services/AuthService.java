package com.springmvc.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.springmvc.exception.InvalidUserException;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;

/**
 * 
 * @author mpasha
 * 
 *         This interface should contains user authentication related methods
 *         only
 */
public interface AuthService
{
	/**
	 * This method will read {@link UserLogin} object and validate details
	 * against database values.
	 * 
	 * @param userLogin
	 *            object contains user credentials
	 * @return {@link UserDetails} object if login credentials are correct else
	 *         return null
	 */
	UserDetails login(UserLogin userLogin);

	/**
	 * This method will reset the user password
	 * 
	 * @param userLogin
	 *            object contains user credentials
	 * @return {@link UserDetails} object if login credentials are correct else
	 *         return null
	 */
	UserLogin resetPassword(UserLogin userLogin);

	/**
	 * This method will send the reset password URL along with token to the
	 * registered email id of corresponding user
	 * 
	 * @param userLogin
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidUserException
	 * @throws IOException 
	 */
	boolean sendResetPasswordToken(UserLogin userLogin) throws NoSuchAlgorithmException, InvalidUserException, IOException;

	/**
	 * This method will validate the reset password token received from user. It
	 * token is valid one, then corresponding user details will be sent back,
	 * else returns null
	 * 
	 * @param token
	 * @return
	 */
	UserDetails validateResetPasswordToken(String token);

	/**
	 * This will delete the used token of an user
	 * 
	 * @param userId
	 *            to be deleted
	 * @return deletion state           
	 */
	int deleteResetPasswordToken(long userId);
}
