package com.springmvc.services;

import java.security.NoSuchAlgorithmException;

import com.springmvc.exception.InvalidUserException;
import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;

public interface AuthService
{
	UserDetails login(UserLogin userLogin);

	UserLogin resetPassword(UserLogin userLogin);

	boolean sendResetPasswordToken(UserLogin userLogin) throws NoSuchAlgorithmException, InvalidUserException;

	UserDetails validateResetPasswordToken(String token);
}
