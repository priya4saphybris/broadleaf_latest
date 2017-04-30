package com.myapp.core.catalog.model;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.store.domain.Store;

public interface StoreCategoryXref 
{
	public abstract void setId(Long paramLong);

	public abstract Long getId();
	
	public abstract void setMyCategory(Category myCategory);
	
	public abstract Category getMyCategory();
	
	public abstract void setMyStore(Store myStore);
	
	public abstract Store getMyStore();
}
