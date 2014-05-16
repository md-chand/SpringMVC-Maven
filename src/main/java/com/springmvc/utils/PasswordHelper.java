package com.springmvc.utils;

import java.util.Random;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * This class will provide a static methods which are related to password
 * encoding using spring security's ShaPasswordEncoder
 * 
 * @author mpasha
 * 
 */
@SuppressWarnings("deprecation")
public class PasswordHelper
{
	private static final PasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);

	/**
	 * This will return an encrypted password using raw password and salt sent
	 * in as input parameters
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encodePassword(String password, String salt)
	{
		return passwordEncoder.encodePassword(password, salt);
	}

	/**
	 * This method will generate a salt variable to generate default password.
	 * 
	 * @return default salt variable used for generating new password.
	 */
	public static String getDefaultPassword()
	{
		Random random = new Random();
		String passwordSourceStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%*";
		int range = (passwordSourceStr.length() - 1) - 0 + 1;
		int passwordLength = 8;
		String password = "";
		while (passwordLength > 0)
		{
			password += passwordSourceStr.charAt(random.nextInt(range) + 0);
			passwordLength--;
		}
		return password;
	}
}
