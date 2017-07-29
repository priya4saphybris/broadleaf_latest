package com.myapp.core.catalog.model;

import java.util.List;


public interface Services 
{
	Long getId();
	void setId(Long id);
	Area getArea();
	void setArea(Area area);
	List<ServicesCategoryXref> getAvailableCategories();
	void setAvailableCategories(List<ServicesCategoryXref> availableCategories);
}
