package com.springmvc.exception;

public class SpringMVCApplicationException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public SpringMVCApplicationException(String message)
	{
		super(message);
	}

	public SpringMVCApplicationException(Throwable cause)
	{
		super(cause);
	}

	public SpringMVCApplicationException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
