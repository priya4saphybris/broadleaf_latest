package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

public interface MyCustomerService 
{
	List<Customer> readAllCustomers();
}
