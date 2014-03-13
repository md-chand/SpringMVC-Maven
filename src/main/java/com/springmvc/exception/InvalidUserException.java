package com.springmvc.exception;

public class InvalidUserException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message)
	{
		super(message);
	}

	public InvalidUserException(Throwable cause)
	{
		super(cause);
	}

	public InvalidUserException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
