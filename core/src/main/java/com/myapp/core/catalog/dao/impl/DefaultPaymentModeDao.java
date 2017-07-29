package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myapp.core.catalog.dao.PaymentModeDao;
import com.myapp.core.catalog.model.PaymentMode;
import com.myapp.core.catalog.model.PaymentModeImpl;

public class DefaultPaymentModeDao implements PaymentModeDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMode> getPaymentModesForStoreFront() 
	{
		TypedQuery typedQuery= this.em.createQuery("FROM "+com.myapp.core.catalog.model.PaymentModeImpl.class.getName()+" WHERE active=:isActive", PaymentModeImpl.class);
		typedQuery.setParameter("isActive", Boolean.valueOf(true));
		typedQuery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		typedQuery.setHint("org.hibernate.cacheRegion", "blStandardElements");
		return typedQuery.getResultList();
	}

}
