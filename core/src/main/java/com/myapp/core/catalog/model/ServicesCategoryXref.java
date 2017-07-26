package com.myapp.core.catalog.model;

import org.broadleafcommerce.core.catalog.domain.Category;

public interface ServicesCategoryXref 
{
	void setId(Long id);
	Long getId();
	Services getService();
	void setService(Services service);
	Category getCategory();
	void setCategory(Category category);
}
