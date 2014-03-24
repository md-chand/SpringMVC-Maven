package com.springmvc.utils;

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
}
