package com.myapp.core.education.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.myapp.core.education.dao.InstituteDao;
import com.myapp.core.education.organization.Institute;

public class DefaultInstituteDao implements InstituteDao
{
	@PersistenceContext(unitName = "blPU")
	private EntityManager em;
	
	@Override
	public Institute save(Institute institute) 
	{
		return this.em.merge(institute);
	}

	@Override
	public List<Institute> getInstitues() 
	{
		TypedQuery<Institute> query = this.em.createQuery("FROM "+com.myapp.core.education.organization.Institute.class.getName(), Institute.class);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "blStandardElements");
		return query.getResultList();
	}

	@Override
	public Institute getInstitute(Long id) 
	{
		return this.em.find(Institute.class, id);
	}
	
}
