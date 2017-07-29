package com.myapp.core.catalog.service.impl;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.catalog.dao.MyCustomerDao;
import com.myapp.core.catalog.service.MyCustomerService;
import com.myapp.core.user.MyCustomer;

public class DefaultCustomerService implements MyCustomerService
{
	private MyCustomerDao customerDao;
	
	public MyCustomerDao getCustomerDao() {
		return customerDao;
	}


	public void setCustomerDao(MyCustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	@Override
	public List<Customer> readAllCustomers() 
	{
		return customerDao.readAllCustomers();
	}


	@Override
	public MyCustomer save(MyCustomer myCustomer) 
	{
		return customerDao.saveCustomer(myCustomer);
	}

}
