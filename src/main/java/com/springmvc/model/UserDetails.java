package com.springmvc.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.springmvc.common.UserRole;

/**
 * 
 * @author mpasha
 * 
 */
public class UserDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String name;
	private String contactNumber;
	private String email;
	private String userName;
	private String password;
	private byte[] avatar;
	private String gender;
	private UserRole role;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getContactNumber()
	{
		return contactNumber;
	}

	public void setContactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public byte[] getAvatar()
	{
		return avatar;
	}

	public void setAvatar(byte[] avatar)
	{
		this.avatar = avatar;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public UserRole getRole()
	{
		return role;
	}

	public void setRole(UserRole role)
	{
		this.role = role;
	}

	@Override
	public String toString()
	{
		return "UserDetails [userId=" + userId + ", name=" + name + ", contactNumber=" + contactNumber + ", email="
				+ email + ", userName=" + userName + ", password=" + password + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetails other = (UserDetails) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

}
