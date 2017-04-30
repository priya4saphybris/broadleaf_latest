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
	}

}
