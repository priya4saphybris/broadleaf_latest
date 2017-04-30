package com.myapp.core.catalog.model;

import java.util.List;


public interface MyCategory
{
	List<StoreCategoryXref> getAllStoreCategoryXrefs();
	void setAllStoreCategoryXrefs(List<StoreCategoryXref> allStoreCategoryXrefs);
}
