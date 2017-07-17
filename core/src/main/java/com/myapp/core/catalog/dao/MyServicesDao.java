package com.myapp.core.catalog.dao;

import java.util.List;

import com.myapp.core.catalog.model.Services;

public interface MyServicesDao 
{
	List<Services> getServicesForCity(String areaCode);
}
