package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.catalog.facades.CategoryFacade;
import com.myapp.core.catalog.model.ServicesCategoryXref;
import com.myapp.core.catalog.service.MyCategoryService;
import com.myapp.core.catalog.service.MyServicesService;
import com.myapp.core.converter.Converter;

public class DefaultCategoryFacade implements CategoryFacade
{
	private Converter<Category, CategoryData> categoryConverter;
	
	private MyCategoryService categoryService;
	
	private MyServicesService myServicesService;
	
	
	public MyServicesService getMyServicesService() {
		return myServicesService;
	}


	public void setMyServicesService(MyServicesService myServicesService) {
		this.myServicesService = myServicesService;
	}


	public Converter<Category, CategoryData> getCategoryConverter() {
		return categoryConverter;
	}


	public void setCategoryConverter(Converter<Category, CategoryData> categoryConverter) {
		this.categoryConverter = categoryConverter;
	}


	public MyCategoryService getCategoryService() {
		return categoryService;
	}


	public void setCategoryService(MyCategoryService categoryService) {
		this.categoryService = categoryService;
	}


	@Override
	public List<CategoryData> readCategoriesFromStore(Long storeId) 
	{
		List<Category> categories= categoryService.readCategoriesFromStore(storeId);
		List<CategoryData> categoryList= new ArrayList<CategoryData>();
		if(!CollectionUtils.isEmpty(categories))
		{
			for(Category category: categories)
			{
				CategoryData categoryData=categoryConverter.convert(category);
				categoryList.add(categoryData);
			}
		}
		return categoryList;
	}


	@Override
	public List<CategoryData> getCategoriesFromArea(String areaCode) 
	{
		List<ServicesCategoryXref> categories=myServicesService.getServicesForArea(areaCode);
		
		List<CategoryData> categoryList= new ArrayList<CategoryData>();
		
		if(!CollectionUtils.isEmpty(categories))
		{
			for(ServicesCategoryXref category: categories)
			{
				CategoryData categoryData=categoryConverter.convert(category.getCategory());
				categoryList.add(categoryData);
			}
		}
		
		return categoryList;
	}
	
}
