package com.myapp.core.catalog.service;

import java.util.List;


import com.myapp.core.user.MyCustomer;

public interface MyCustomerService 
{
	List<MyCustomer> readAllCustomers();
	MyCustomer save(MyCustomer myCustomer);
	MyCustomer readCustomerById(Long id);
}
