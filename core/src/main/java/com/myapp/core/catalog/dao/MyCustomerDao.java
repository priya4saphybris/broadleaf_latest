package com.myapp.core.catalog.dao;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

public interface MyCustomerDao 
{
	public List<Customer> readAllCustomers();
}
