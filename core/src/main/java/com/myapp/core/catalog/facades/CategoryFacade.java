package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.CategoryData;

public interface CategoryFacade 
{
	List<CategoryData> readCategoriesFromStore(Long storeId);
	List<CategoryData> getCategoriesFromArea(String areaCode);
}
