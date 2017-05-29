package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.CustomerData;

public interface CustomerFacade 
{
	List<CustomerData> readAllCustomers();
}
