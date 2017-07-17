package com.myapp.core.catalog.service;


import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;


public interface MyServicesService 
{
	List<Category> getServicesForCity(String areaCode);
}
