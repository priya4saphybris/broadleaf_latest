package com.myapp.core.catalog.facades;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.beans.AddressData;
import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.user.MyCustomer;

public interface CustomerFacade 
{
	//CustomerData registerCustomer(MyCustomerForm customerForm);
	List<CustomerData> readAllCustomers();
	CustomerData selectLocation(CurrentLocationData currentLocation, MyCustomer customer);
	CustomerData getCurrentCustomer(Customer customer);
}
