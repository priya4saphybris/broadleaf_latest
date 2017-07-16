package com.myapp.core.catalog.model;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;

public interface Area 
{
	Long getId();
	void setId(Long id);
	String getAreaCode();
	void setAreaCode(String areaCode);
	String getAreaName();
	void setAreaName(String areaName);
	CountrySubdivision getCityCode();
	void setCityCode(CountrySubdivision cityCode);
}
