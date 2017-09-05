package com.myapp.core.catalog.facades.impl;

import java.util.List;
import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.catalog.facades.CustomerFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.service.MyCustomerService;
import com.myapp.core.catalog.service.MyLocationService;
import com.myapp.core.converter.Converter;
import com.myapp.core.user.MyCustomer;

public class DefaultCustomerFacade implements CustomerFacade
{
	private MyCustomerService myCustomerService;
	
	private Converter<MyCustomer, CustomerData> customerConverter;
	
	private MyLocationService locationService;
	
	public MyLocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(MyLocationService locationService) {
		this.locationService = locationService;
	}

	public MyCustomerService getMyCustomerService() {
		return myCustomerService;
	}

	public void setMyCustomerService(MyCustomerService myCustomerService) {
		this.myCustomerService = myCustomerService;
	}

	public Converter<MyCustomer, CustomerData> getCustomerConverter() {
		return customerConverter;
	}

	public void setCustomerConverter(Converter<MyCustomer, CustomerData> customerConverter) {
		this.customerConverter = customerConverter;
	}

	@Override
	public List<CustomerData> readAllCustomers() 
	{
		List<MyCustomer> customers=myCustomerService.readAllCustomers();
		return customerConverter.convertAll(customers);
	}

	@Override
	public CustomerData selectLocation(CurrentLocationData currentLocation, MyCustomer customer) 
	{
		Area area=locationService.findArea(currentLocation.getAreaCode());
		
		if(null != area)
		{
			customer.setArea(area);
			MyCustomer updatedCustomer=myCustomerService.save(customer);
			return customerConverter.convert(updatedCustomer);
		}
		return null;
	}
}
