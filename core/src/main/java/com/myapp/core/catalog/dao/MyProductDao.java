package com.myapp.core.catalog.dao;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Product;

public interface MyProductDao 
{
	List<Product> readProductsFromStore(Long storeId);
}
