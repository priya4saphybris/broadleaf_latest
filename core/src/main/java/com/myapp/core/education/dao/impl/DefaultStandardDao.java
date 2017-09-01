package com.myapp.core.education.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myapp.core.education.dao.StandardDao;
import com.myapp.core.education.standard.Standard;

public class DefaultStandardDao implements StandardDao
{
	@PersistenceContext(unitName = "blPU")
	private EntityManager em;
	
	@Override
	public Standard save(Standard standard) 
	{
		return this.em.merge(standard);
	}

	@Override
	public Standard getStandardById(Long id) 
	{
		return this.em.find(Standard.class, id);
	}

	@Override
	public List<Standard> getStandards() 
	{
		TypedQuery<Standard> query = this.em.createQuery("FROM "+com.myapp.core.education.standard.Standard.class.getName(), Standard.class);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "blStandardElements");
		return query.getResultList();
	}

}
