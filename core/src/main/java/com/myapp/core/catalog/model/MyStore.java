package com.myapp.core.catalog.model;

import java.util.List;

import com.myapp.core.user.MyCustomer;

public interface MyStore 
{
	List<StoreCategoryXref> getAllCategoryXrefs();
	void setAllCategoryXrefs(List<StoreCategoryXref> allCategoryXrefs);
	MyCustomer getAdmin();
	void setAdmin(MyCustomer admin);
}
