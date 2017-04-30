package com.myapp.core.catalog.facades;

import java.util.List;

import org.broadleafcommerce.core.search.domain.SearchCriteria;

import com.myapp.core.beans.ProductData;

public interface ProductFacade 
{
	ProductData getProductForID(Long id);
	List<ProductData> findProductsForCategory(String categoryCode, SearchCriteria searchCriteria);
	List<ProductData> readProductsFromStore(Long StoreId);
}
