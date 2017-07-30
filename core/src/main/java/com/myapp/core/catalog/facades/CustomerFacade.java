package com.myapp.core.catalog.facades;

import java.util.List;


import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.user.MyCustomer;

public interface CustomerFacade 
{
	List<CustomerData> readAllCustomers();
	CustomerData selectLocation(CurrentLocationData currentLocation, MyCustomer customer);
}
