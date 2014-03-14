/**
 * 
 */
package com.springmvc.services.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.entity.TokenAuthenticationEntity;
import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.entitymanager.AuthManager;
import com.springmvc.entitymanager.TokenManager;
import com.springmvc.exception.InvalidUserException;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;
import com.springmvc.services.AuthService;
import com.springmvc.services.MailService;
import com.springmvc.services.UserService;
import com.springmvc.utils.EntityConverter;

/**
 * @author mpasha
 * 
 */

@Service
public class AuthServiceImpl implements AuthService
{

	@Autowired
	private AuthManager authManager;

	@Autowired
	private TokenManager tokenManager;

	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private MailService mailServiceImpl;

	@Override
	public UserDetails login(UserLogin userLogin)
	{
		UserDetails userDetails = null;
		List<UserDetailsEntity> userList = authManager.validateUser(userLogin);
		if (!userList.isEmpty())
		{
			UserDetailsEntity userDetailsEntity = userList.get(0);
			userDetails = EntityConverter.fromEntity(userDetailsEntity);
		}
		return userDetails;
	}

	@Override
	@Transactional
	public boolean sendResetPasswordToken(UserLogin userLogin) throws NoSuchAlgorithmException
	{
		boolean result = true;
		UserDetails userDetails = null;
		if (!StringUtils.isEmpty(userLogin.getUserName()))
		{
			userDetails = userServiceImpl.getUserByUserName(userLogin.getUserName());
		}
		if (userDetails == null && !StringUtils.isEmpty(userLogin.getEmail()))
		{
			userDetails = userServiceImpl.getUserByEmail(userLogin.getEmail());
		}
		if (userDetails == null)
		{
			throw new InvalidUserException("No user exist with the username / password entered.");
		}
		UserDetailsEntity userDetailsEntity = EntityConverter.toEntity(userDetails);
		String token = getToken().replace("+", "Q");
		TokenAuthenticationEntity tokenAuthEntity = tokenManager.storeAuthenticationToken(userDetailsEntity, token);
		if (tokenAuthEntity == null)
		{
			result = false;
		}
		else
		{
			mailServiceImpl.sendForgotPasswordTokenMail(userDetails.getEmail(), token);
		}
		return result;
	}

	@Override
	public UserDetails validateResetPasswordToken(String token)
	{
		List<TokenAuthenticationEntity> tokenAuthEntityList = tokenManager.getTokenEntityByToken(token);
		UserDetails userDetails = null;
		if (tokenAuthEntityList.size() != 1)
		{
			return null;
		}
		TokenAuthenticationEntity tokenAuthenticationEntity = tokenAuthEntityList.get(0);
		userDetails = EntityConverter.fromEntity(tokenAuthenticationEntity.getUserDetailsEntity());
		return userDetails;
	}

	@Override
	public UserLogin resetPassword(UserLogin userLogin)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private String getToken() throws NoSuchAlgorithmException
	{
		// Validate if sent user name (is valid or not) here
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		byte[] bytes = secureRandom.generateSeed(18);
		/** encoding secureRandom generate bytes with apache commons base-64 */
		byte[] encoded = Base64.encodeBase64(bytes);
		String token = new String(encoded);
		// Add to DB against user id then send the token
		return token;
	}

}
