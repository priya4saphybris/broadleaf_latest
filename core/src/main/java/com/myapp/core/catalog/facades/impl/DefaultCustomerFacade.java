package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.CustomerData;
import com.myapp.core.catalog.facades.CustomerFacade;
import com.myapp.core.catalog.service.MyCustomerService;
import com.myapp.core.converter.Converter;

public class DefaultCustomerFacade implements CustomerFacade
{
	private MyCustomerService myCustomerService;
	
	private Converter<Customer, CustomerData> customerConverter;
	
	
	public MyCustomerService getMyCustomerService() {
		return myCustomerService;
	}

	public void setMyCustomerService(MyCustomerService myCustomerService) {
		this.myCustomerService = myCustomerService;
	}

	public Converter<Customer, CustomerData> getCustomerConverter() {
		return customerConverter;
	}

	public void setCustomerConverter(Converter<Customer, CustomerData> customerConverter) {
		this.customerConverter = customerConverter;
	}

	@Override
	public List<CustomerData> readAllCustomers() 
	{
		List<Customer> customers=myCustomerService.readAllCustomers();
		return convert(customers);
	}

	protected List<CustomerData> convert(List<Customer> customers)
	{
		List<CustomerData> customersList= new ArrayList<CustomerData>();
		
		if(null != customers && !CollectionUtils.isEmpty(customers))
		{
			for(Customer customer: customers)
			{
				customersList.add(customerConverter.convert(customer));
			}
			
		}
		return customersList;
		
	}
}
