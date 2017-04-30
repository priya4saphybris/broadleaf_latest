package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;

public interface MyCategoryService 
{
	List<Category> readCategoriesFromStore(Long storeId);
}
