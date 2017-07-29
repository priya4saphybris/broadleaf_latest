package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.catalog.facades.MyServicesFacade;
import com.myapp.core.catalog.model.ServicesCategoryXref;
import com.myapp.core.catalog.service.MyServicesService;
import com.myapp.core.converter.Converter;

public class DefaultServicesFacade implements MyServicesFacade
{
	private MyServicesService myServicesService;
	
	private Converter<Category, CategoryData> categoryConverter;
	
	public Converter<Category, CategoryData> getCategoryConverter() {
		return categoryConverter;
	}


	public void setCategoryConverter(Converter<Category, CategoryData> categoryConverter) {
		this.categoryConverter = categoryConverter;
	}


	public MyServicesService getMyServicesService() {
		return myServicesService;
	}


	public void setMyServicesService(MyServicesService myServicesService) {
		this.myServicesService = myServicesService;
	}


	@Override
	public List<CategoryData> getServicesForCity(String areaCode) 
	{
		List<ServicesCategoryXref> categories=myServicesService.getServicesForArea(areaCode);
		List<CategoryData> categoryList= new ArrayList<CategoryData>();
		if(null != categories)
		{
			for(ServicesCategoryXref category: categories)
			{
				CategoryData categoryData=categoryConverter.convert(category.getCategory());
				categoryList.add(categoryData);
			}
			
			return categoryList;
		}
		
		return null;
	}
	
}
