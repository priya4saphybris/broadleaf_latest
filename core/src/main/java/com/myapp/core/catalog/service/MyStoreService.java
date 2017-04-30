package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Product;

public interface MyStoreService 
{
	List<Product> readProductsFromStore(Long storeId);
}
