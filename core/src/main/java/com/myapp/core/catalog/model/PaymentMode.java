package com.myapp.core.catalog.model;

public interface PaymentMode 
{
	Long getId();
	void setId(Long id);
	String getCode();
	void setCode(String code);
	String getLogoImage();
	void setLogoImage(String logoImage);
	String getType();
	void setType(String type);
	boolean isActive();
	void setActive(boolean active);
}
