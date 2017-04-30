package com.myapp.core.catalog.model;

import org.broadleafcommerce.core.store.domain.Store;

public interface MyProduct 
{
	void setStore(Store store);
	Store getStore();
}
