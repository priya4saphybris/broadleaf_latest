package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.store.domain.StoreImpl;

import com.myapp.core.catalog.dao.MyProductDao;
import com.myapp.core.catalog.model.MyProduct;

public class DefaultProductDao implements MyProductDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@Resource(name = "blSandBoxHelper")
	protected SandBoxHelper sandBoxHelper;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Product> readProductsFromStore(Long storeId) 
	{
		TypedQuery query = this.em.createQuery("FROM "+com.myapp.core.catalog.model.MyProductImpl.class.getName()+" storeProducts "
				+ "WHERE storeProducts.store.id = :storeId", MyProduct.class);
		query.setParameter("storeId",
				this.sandBoxHelper.mergeCloneIds(StoreImpl.class, new Long[] { storeId }));
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "query.Catalog");
		return query.getResultList();
	}
	
}
