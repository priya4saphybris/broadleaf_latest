package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.broadleafcommerce.core.catalog.domain.Category;

import com.myapp.core.catalog.dao.MyCategoryDao;


public class MyCategoryDaoImpl implements MyCategoryDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Category> readStoreCategoriesByName(String categoryName, int limit, int offset) 
	{
		TypedQuery query = this.em.createNamedQuery("BC_READ_CATEGORY_BY_NAME", Category.class);
		query.setParameter("categoryName", categoryName);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "query.Catalog");
		query.setFirstResult(offset);
		query.setMaxResults(limit);

		return query.getResultList();
	}
	
}
