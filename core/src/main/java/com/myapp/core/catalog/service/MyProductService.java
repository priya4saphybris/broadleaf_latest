package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Product;

public interface MyProductService 
{
	List<Product> readAllProductsFromStore(Long storeId);
}


		