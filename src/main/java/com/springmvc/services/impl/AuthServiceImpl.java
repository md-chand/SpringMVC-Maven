/**
 * 
 */
package com.springmvc.services.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.UserManager;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthService;
import com.springmvc.utils.EntityConverter;

/**
 * @author mpasha
 * 
 */

@Service
public class AuthServiceImpl implements AuthService
{

	@Autowired
	public UserManager userRepository;

	@Override
	public UserDetails login(UserLogin userLogin)
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
	public UserLogin resetPassword(UserLogin userLogin)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswordResetToken(String username) throws NoSuchAlgorithmException
	{
//		Validate if sent user name (is valid or not) here
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] bytes = secureRandom.generateSeed(18);
		/** encoding secureRandom generate bytes with apache commons base-64 */
		byte[] encoded = Base64.encodeBase64(bytes);
		String token = new String(encoded);
//		Add to DB against user id then send the token
		return token;
	}

	@Override
	public boolean validateResetPasswordToken(String token)
	{
		// TODO Auto-generated method stub
		return false;
	}

}
