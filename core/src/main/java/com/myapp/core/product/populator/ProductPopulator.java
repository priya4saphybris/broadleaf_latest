package com.myapp.core.product.populator;

import org.broadleafcommerce.core.catalog.domain.ProductImpl;

import com.myapp.core.beans.ProductData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class ProductPopulator implements Populator<ProductImpl, ProductData>
{
	@Override
	public void populate(ProductImpl productModel, ProductData productData) throws ConvertionException 
	{
		productData.setId(productModel.getId());
		productData.setName(productModel.getName());
		productData.setBrand(productModel.getManufacturer());
		productData.setCurrency("INR");
		productData.setUrl(productModel.getGeneratedUrl());
		productData.setDescription(productModel.getDescription());
		productData.setPrice(String.valueOf(productModel.getSalePrice()));
		productData.setPrice_formatted(productModel.getSalePrice().toString()+" INR");
		productData.setDiscount_price(productModel.getRetailPrice().toString());
		productData.setDiscount_price_formatted(productModel.getRetailPrice()+" INR");
		
	}

}
