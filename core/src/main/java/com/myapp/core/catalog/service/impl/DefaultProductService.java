package com.myapp.core.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.core.catalog.domain.Product;

import com.myapp.core.catalog.dao.MyProductDao;
import com.myapp.core.catalog.service.MyProductService;

public class DefaultProductService implements MyProductService
{
	private MyProductDao productDao;
	
	public MyProductDao getProductDao() {
		return productDao;
	}


	public void setProductDao(MyProductDao productDao) {
		this.productDao = productDao;
	}


	@Override
	public List<Product> readAllProductsFromStore(Long storeId) 
	{
		return productDao.readProductsFromStore(storeId);
	}
}
