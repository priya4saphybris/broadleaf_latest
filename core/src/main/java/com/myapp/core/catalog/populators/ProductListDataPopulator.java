package com.myapp.core.catalog.populators;

import org.broadleafcommerce.core.catalog.domain.Product;

import com.myapp.core.catalog.beans.ProductItemData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class ProductListDataPopulator implements Populator<Product, ProductItemData>
{

	@Override
	public void populate(Product source, ProductItemData target) throws ConvertionException 
	{
		target.setId(target.getId());
		target.setCategory(source.getCategory().getId());
		//target.setCurrency(source.getC);
		target.setDescription(source.getDescription());
		//target.setDiscountPrice(source.getPrice);
		target.setUrl(target.getUrl());
		
	}
	
}
