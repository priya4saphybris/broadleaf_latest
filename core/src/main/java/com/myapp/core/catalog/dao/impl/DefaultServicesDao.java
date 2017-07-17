package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.myapp.core.catalog.dao.MyServicesDao;
import com.myapp.core.catalog.model.Services;
import com.myapp.core.catalog.model.ServicesImpl;

public class DefaultServicesDao implements MyServicesDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@Override
	public List<Services> getServicesForCity(String areaCode) 
	{
		TypedQuery query = this.em.createQuery("FROM "+com.myapp.core.catalog.model.ServicesImpl.class.getName()+" WHERE area.areaCode =:areaCode", ServicesImpl.class);
		query.setParameter("areaCode", areaCode);
		return query.getResultList();
	}
	
}
