package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.catalog.model.Area;

public interface MyServicesFacade 
{
	List<Area> getServicesForCity(String areaCode);
}