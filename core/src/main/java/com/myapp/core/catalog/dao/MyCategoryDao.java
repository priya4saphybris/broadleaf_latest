package com.myapp.core.catalog.dao;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;

public interface MyCategoryDao 
{
	List<Category> readStoreCategoriesByName(String categoryName, int limit, int offset);
}
