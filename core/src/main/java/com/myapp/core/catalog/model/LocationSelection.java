package com.myapp.core.catalog.model;

public interface LocationSelection 
{
	void setId(Long id);
	Long getId();
	void setCityCode(String cityCode);
	String getCityCode();
	void setStateCode(String stateCode);
	String getStateCode();
}
