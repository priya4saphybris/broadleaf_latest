package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.core.store.domain.Store;
import org.broadleafcommerce.core.store.domain.StoreImpl;
import org.broadleafcommerce.core.store.service.StoreService;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.StoreData;
import com.myapp.core.catalog.facades.StoreFacade;
import com.myapp.core.converter.Converter;

public class DefaultStoreFacade implements StoreFacade
{
	@Resource(name="blStoreService")
	private StoreService storeService;
	
	private Converter<Store, StoreData> storeConverter;
	
	
	public StoreService getStoreService() {
		return storeService;
	}


	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}


	public Converter<Store, StoreData> getStoreConverter() {
		return storeConverter;
	}


	public void setStoreConverter(Converter<Store, StoreData> storeConverter) {
		this.storeConverter = storeConverter;
	}


	@Override
	public List<StoreData> getAllStores() 
	{
		List<Store> stores=storeService.readAllStores();
		List<StoreData> storeList= new ArrayList<StoreData>();
		if(null != stores || !CollectionUtils.isEmpty(stores))
		{
			for(Store store: stores)
			{
				StoreData storeData=storeConverter.convert(store);
				storeList.add(storeData);
			}
		}
		return storeList;
	}


	@Override
	public StoreData readStoreByStoreId(Long storeId) 
	{
		Store store=storeService.readStoreById(storeId);
		
		if(null != store)
		{
			return storeConverter.convert(store);
		}
		return null;
	}


	@Override
	public boolean createStore(StoreData storeData) 
	{
		Store store= new StoreImpl();
		store.setName(storeData.getName());
		store.setStoreHours(storeData.getStoreHours());
		
		try
		{
			storeService.saveStore(store);
		}
		catch(Exception ex)
		{
			return false;
		}
		return true;
	}

}
