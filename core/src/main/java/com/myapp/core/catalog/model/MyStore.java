package com.myapp.core.catalog.model;

import java.util.List;

public interface MyStore 
{
	List<StoreCategoryXref> getAllCategoryXrefs();
	void setAllCategoryXrefs(List<StoreCategoryXref> allCategoryXrefs);
}
