package com.myapp.core.catalog.service;


import java.util.List;


import com.myapp.core.catalog.model.ServicesCategoryXref;


public interface MyServicesService 
{
	List<ServicesCategoryXref> getServicesForArea(String areaCode);
}
