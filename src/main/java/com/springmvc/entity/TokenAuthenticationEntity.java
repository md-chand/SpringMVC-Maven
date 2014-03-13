package com.springmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "token_authentication")
public class TokenAuthenticationEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "auth_id")
	private long authId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id", nullable = false)
	private UserDetailsEntity userDetailsEntity;

	@Column(name = "token")
	private String token;

	@Column(name = "token_creation_time")
	private Date tokenCreationDate;

	public long getAuthId()
	{
		return authId;
	}

	public void setAuthId(long authId)
	{
		this.authId = authId;
	}

	public UserDetailsEntity getUserDetailsEntity()
	{
		return userDetailsEntity;
	}

	public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity)
	{
		this.userDetailsEntity = userDetailsEntity;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public Date getTokenCreationDate()
	{
		return tokenCreationDate;
	}

	public void setTokenCreationDate(Date tokenCreationDate)
	{
		this.tokenCreationDate = tokenCreationDate;
	}
}
