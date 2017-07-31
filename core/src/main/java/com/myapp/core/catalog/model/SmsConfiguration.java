package com.myapp.core.catalog.model;

public interface SmsConfiguration 
{
	Long getId();
	void setId(Long id);
	String getUsername();
	void setUsername(String username);
	String getPassword();
	void setPassword(String password);
	String getUrl();
	void setUrl(String url);
	String getSender();
	void setSender(String sender);
}