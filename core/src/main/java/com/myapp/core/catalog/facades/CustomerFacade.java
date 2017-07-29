package com.myapp.core.catalog.facades;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.CustomerData;

public interface CustomerFacade 
{
	List<CustomerData> readAllCustomers();
	CustomerData selectLocation(CurrentLocationData currentLocation, Customer customer);
}
