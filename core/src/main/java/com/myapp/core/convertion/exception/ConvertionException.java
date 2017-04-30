package com.myapp.core.convertion.exception;

public class ConvertionException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ConvertionException(String message, Throwable reason)
	{
		super(message, reason);
	}
	
	public ConvertionException(String message)
	{
		super(message);
	}
}
