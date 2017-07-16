package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.domain.StateImpl;

import com.myapp.core.catalog.dao.MyLocationDao;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.model.AreaImpl;

public class DefaultLocationDao implements MyLocationDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<State> getRegionsStartWith(String query) 
	{
		@SuppressWarnings("rawtypes")
		TypedQuery typedquery = this.em.createQuery("FROM "+org.broadleafcommerce.profile.core.domain.StateImpl.class.getName()+" states where states.name like :name", StateImpl.class);
		typedquery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		typedquery.setHint("org.hibernate.cacheRegion", "blStandardElements");
		
		typedquery.setParameter("name",query.toUpperCase()+"%");
		typedquery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		return typedquery.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CountrySubdivision> getCitiesStartWith(String query) 
	{
		@SuppressWarnings("rawtypes")
		TypedQuery typedquery = this.em.createQuery("FROM "+org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl.class.getName()+" cities where cities.name like :name", CountrySubdivisionImpl.class);
		typedquery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		typedquery.setHint("org.hibernate.cacheRegion", "blStandardElements");
		
		typedquery.setParameter("name",query.toUpperCase()+"%");
		typedquery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		return typedquery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Area> getAllAreas()
	{
		TypedQuery typedquery = this.em.createQuery("FROM "+com.myapp.core.catalog.model.AreaImpl.class.getName(), AreaImpl.class);
		typedquery.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		typedquery.setHint("org.hibernate.cacheRegion", "blStandardElements");
		return typedquery.getResultList();
	}
}
