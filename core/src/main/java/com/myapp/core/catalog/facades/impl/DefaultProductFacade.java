package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.ProductData;
import com.myapp.core.catalog.facades.ProductFacade;
import com.myapp.core.catalog.service.MyProductService;
import com.myapp.core.converter.Converter;
import com.myapp.core.convertion.exception.ProductNotFoundException;

public class DefaultProductFacade implements ProductFacade
{
	@Resource(name="blCatalogService")
	private CatalogService catalogService;
	
	private Converter<Product,ProductData> productConverter;
	
	private MyProductService productService;
	
	public MyProductService getProductService() {
		return productService;
	}

	public void setProductService(MyProductService productService) {
		this.productService = productService;
	}

	public CatalogService getCatalogService() {
		return catalogService;
	}

	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}

	public Converter<Product, ProductData> getProductConverter() {
		return productConverter;
	}

	public void setProductConverter(Converter<Product, ProductData> productConverter) {
		this.productConverter = productConverter;
	}

	@Override
	public ProductData getProductForID(Long productId) 
	{
		Product product=catalogService.findProductById(productId);
		
		if(null != product)
		{
			ProductData productData=productConverter.convert(product);
			return productData;
		}
		else
		{
			throw new ProductNotFoundException("Product not found with ID:"+productId);
		}
	}

	@Override
	public List<ProductData> findProductsForCategory(String categoryCode, SearchCriteria searchCriteria) 
	{
		Category category=null;
		try
		{
			Long categoryId=Long.valueOf(categoryCode);
			category=catalogService.findCategoryById(categoryId);
			
		}
		catch(Exception e)
		{
			return Collections.emptyList();
		}
		
		if(null != category)
		{
			List<Product> products=catalogService.findProductsForCategory(category, searchCriteria.getPageSize().intValue(), searchCriteria.getPage().intValue());
			
			return convert(products);
		}
		
		return Collections.emptyList();
	}

	private List<ProductData> convert(List<Product> products) 
	{
		List<ProductData> productsList= new ArrayList<ProductData>();
		if(null != products || !CollectionUtils.isEmpty(products))
		{
			 for(Product product: products)
			 {
				 ProductData productData=productConverter.convert(product);
				 productsList.add(productData);
			 }
			 
			 return productsList;
		}
		return productsList;
	}

	@Override
	public List<ProductData> readProductsFromStore(Long storeId) 
	{
		List<Product> products=productService.readAllProductsFromStore(storeId);
		return convert(products);
	}

	
}
