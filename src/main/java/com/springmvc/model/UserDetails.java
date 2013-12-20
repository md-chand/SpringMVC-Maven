package com.springmvc.model;

import java.io.Serializable;

/**
 * 
 * @author mpasha
 * 
 */
public class UserDetails implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String name;
	private String contactNumber;
	private String email;

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

	@Override
	public String toString()
	{
		return "UserDetails [name=" + name + ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
}
