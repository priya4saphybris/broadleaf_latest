package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.user.MyCustomer;

public interface MyCustomerService 
{
	List<Customer> readAllCustomers();
	MyCustomer save(MyCustomer myCustomer);
}
