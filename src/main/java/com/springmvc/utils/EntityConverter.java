package com.springmvc.utils;

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
		return userDetails;
	}

	public static UserDetailsEntity toEntity(UserDetails userDetails)
	{
		UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
		userDetailsEntity.setName(userDetails.getName());
		userDetailsEntity.setContactNumber(userDetails.getContactNumber());
		userDetailsEntity.setEmail(userDetails.getEmail());
		userDetailsEntity.setUserName(userDetails.getUserName());
		userDetailsEntity.setPassword(userDetails.getPassword());
		return userDetailsEntity;
	}
}
