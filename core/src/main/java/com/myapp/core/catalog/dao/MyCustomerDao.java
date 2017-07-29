package com.myapp.core.catalog.dao;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.user.MyCustomer;

public interface MyCustomerDao 
{
	List<Customer> readAllCustomers();
	MyCustomer saveCustomer(MyCustomer myCustomer);
}
