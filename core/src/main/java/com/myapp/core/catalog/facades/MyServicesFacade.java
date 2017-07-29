package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.CategoryData;

public interface MyServicesFacade 
{
	List<CategoryData> getServicesForCity(String areaCode);
}