package com.myapp.core.catalog.dao;

import java.util.List;


import com.myapp.core.user.MyCustomer;

public interface MyCustomerDao 
{
	List<MyCustomer> readAllCustomers();
	MyCustomer saveCustomer(MyCustomer myCustomer);
	MyCustomer findCustomerForId(Long id);
}
