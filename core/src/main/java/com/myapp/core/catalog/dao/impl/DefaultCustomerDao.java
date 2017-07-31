package com.myapp.core.catalog.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;

import com.myapp.core.catalog.dao.MyCustomerDao;
import com.myapp.core.user.MyCustomer;
import com.myapp.core.user.MyCustomerImpl;

public class DefaultCustomerDao implements MyCustomerDao
{
	@PersistenceContext(unitName = "blPU")
	protected EntityManager em;
	
	@Resource(name = "blSandBoxHelper")
	protected SandBoxHelper sandBoxHelper;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<MyCustomer> readAllCustomers() {
		TypedQuery query = this.em.createQuery("FROM "+com.myapp.core.user.MyCustomerImpl.class.getName(), MyCustomerImpl.class);
		query.setHint("org.hibernate.cacheable", Boolean.valueOf(true));
		query.setHint("org.hibernate.cacheRegion", "query.Catalog");
		return query.getResultList();
	}

	@Override
	public MyCustomer saveCustomer(MyCustomer myCustomer) 
	{
		return ((MyCustomer) this.em.merge(myCustomer));
	}

	@Override
	public MyCustomer findCustomerForId(Long id) 
	{
		return ((MyCustomer) this.em.find(MyCustomerImpl.class, id));
	}
	
}
