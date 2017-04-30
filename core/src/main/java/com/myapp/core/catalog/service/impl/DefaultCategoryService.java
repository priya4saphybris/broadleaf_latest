package com.myapp.core.catalog.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.store.domain.Store;
import org.broadleafcommerce.core.store.service.StoreService;
import org.springframework.util.CollectionUtils;

import com.myapp.core.catalog.model.MyStore;
import com.myapp.core.catalog.model.StoreCategoryXref;
import com.myapp.core.catalog.service.MyCategoryService;

public class DefaultCategoryService implements MyCategoryService
{
	@Resource(name="blStoreService")
	private StoreService storeService;
	@Override
	public List<Category> readCategoriesFromStore(Long storeId) 
	{
		List<Category> categories= new ArrayList<Category>();
		Store store=storeService.readStoreById(storeId);
		if(null != store || store instanceof MyStore)
		{
			MyStore myStore=(MyStore) store;
			List<StoreCategoryXref> categoryXrefs=myStore.getAllCategoryXrefs();
			
			if(!CollectionUtils.isEmpty(categoryXrefs))
			{
				for(StoreCategoryXref categoryXref: categoryXrefs)
				{
					categories.add(categoryXref.getMyCategory());
				}
			}
		}
		return categories;
	}
	
}
