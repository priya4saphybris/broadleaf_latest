package com.myapp.core.populators;

import org.broadleafcommerce.core.catalog.domain.Category;

import com.myapp.core.beans.CategoryData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class CategoryPopulator implements Populator<Category, CategoryData>
{

	@Override
	public void populate(Category source, CategoryData target) throws ConvertionException 
	{
		target.setId(String.valueOf(source.getId()));
		//target.setName(source.getName());
	}

}
