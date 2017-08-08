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
		target.setCurrency("INR");
		target.setDescription(source.getDescription());
		target.setUrl(target.getUrl());
		if(null != source.getRetailPrice() && null !=source.getRetailPrice().getAmount())
		{
			target.setPrice(Double.valueOf(source.getRetailPrice().getAmount().doubleValue()));
			target.setPriceFormatted(source.getRetailPrice().getAmount().toString());
		}
		if(null != source.getSalePrice() && null != source.getSalePrice().getAmount())
		{
			target.setDiscountPrice(Double.valueOf(source.getSalePrice().getAmount().toString()));
			target.setDiscountPriceFormatted(source.getSalePrice().getAmount().toString());
		}
	}
	
}
