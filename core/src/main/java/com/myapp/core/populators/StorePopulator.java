package com.myapp.core.populators;

import org.broadleafcommerce.core.store.domain.Store;

import com.myapp.core.beans.StoreData;
import com.myapp.core.catalog.model.MyStore;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class StorePopulator implements Populator<Store, StoreData> 
{

	@Override
	public void populate(Store source, StoreData target) throws ConvertionException 
	{
		target.setId(String.valueOf(source.getId()));
		target.setLatitude(String.valueOf(source.getLatitude()));
		target.setLongitude(String.valueOf(source.getLongitude()));
		target.setStoreHours(source.getStoreHours());
		target.setStoreNumber(source.getStoreNumber());
		if(source instanceof MyStore)
		{
			MyStore myStore = (MyStore) source;
		}
	}

}
