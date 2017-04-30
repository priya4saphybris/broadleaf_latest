package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.StoreData;

public interface StoreFacade 
{
	List<StoreData> getAllStores();
	StoreData readStoreByStoreId(Long storeId);
	boolean createStore(StoreData storeData);
}
