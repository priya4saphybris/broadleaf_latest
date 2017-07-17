package com.myapp.core.catalog.service;


import com.myapp.core.catalog.model.Services;

public interface MyServicesService 
{
	Services getServicesForCity(String areaCode);
}
