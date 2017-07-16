package com.myapp.core.catalog.model;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;

public interface Services 
{
	Long getId();
	void setId(Long id);
	Area getArea();
	void setArea(Area area);
	List<Category> getAvailableCategories();
	void setAvailableCategories(List<Category> availableCategories);
}
