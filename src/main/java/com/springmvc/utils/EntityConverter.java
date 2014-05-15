package com.springmvc.utils;

import java.io.IOException;

import com.springmvc.common.UserRole;
import com.springmvc.entity.UserDetailsEntity;
import com.springmvc.model.UserDetails;

public class EntityConverter
{
	public static UserDetails fromEntity(UserDetailsEntity userDetailsEntity)
	{
		UserDetails userDetails = new UserDetails();
		userDetails.setName(userDetailsEntity.getName());
		userDetails.setContactNumber(userDetailsEntity.getContactNumber());
		userDetails.setEmail(userDetailsEntity.getEmail());
		userDetails.setUserId(userDetailsEntity.getUserId());
		userDetails.setUserName(userDetailsEntity.getUserName());
		userDetails.setPassword(userDetailsEntity.getPassword());
		userDetails.setAvatar(userDetailsEntity.getAvatar());
		userDetails.setGender(userDetailsEntity.getGender());
		userDetails.setRole(UserRole.valueOf(userDetailsEntity.getRole()));
		return userDetails;
	}

	public static UserDetailsEntity toEntity(UserDetails userDetails) throws IOException
	{
		UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
		userDetailsEntity.setUserId(userDetails.getUserId());
		userDetailsEntity.setName(userDetails.getName());
		userDetailsEntity.setContactNumber(userDetails.getContactNumber());
		userDetailsEntity.setEmail(userDetails.getEmail());
		userDetailsEntity.setUserName(userDetails.getUserName());
		userDetailsEntity.setPassword(userDetails.getPassword());
		userDetailsEntity.setAvatar(userDetails.getAvatar());
		userDetailsEntity.setGender(userDetails.getGender());
		userDetailsEntity.setRole(userDetails.getRole().toString());
		return userDetailsEntity;
	}
}
