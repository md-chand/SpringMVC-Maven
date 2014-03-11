package com.springmvc.services;

import java.security.NoSuchAlgorithmException;

import com.springmvc.model.UserDetails;
import com.springmvc.model.UserLogin;

public interface AuthService
{
	UserDetails login(UserLogin userLogin);

	UserLogin resetPassword(UserLogin userLogin);

	String getPasswordResetToken(String username) throws NoSuchAlgorithmException;

	boolean validateResetPasswordToken(String token);
}
