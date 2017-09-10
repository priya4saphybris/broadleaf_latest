package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.AddressData;
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
	@Resource(name = "blCustomerService")
	protected CustomerService customerService;
	
	@Resource(name = "blUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Resource(name="blCustomerAddressService")
	private CustomerAddressService customerAddressService;
	
	private MyCustomerService myCustomerService;
	
	private Converter<MyCustomer, CustomerData> customerConverter;
	
	private MyLocationService locationService;
	
	private Converter<Address, AddressData> addressConverter;
	
	public Converter<Address, AddressData> getAddressConverter() {
		return addressConverter;
	}

	public void setAddressConverter(Converter<Address, AddressData> addressConverter) {
		this.addressConverter = addressConverter;
	}

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

	@Override
	public CustomerData getCurrentCustomer(Customer customer) 
	{
		if(null == customer)
		{
			return null;
		}
		return customerConverter.convert((MyCustomer)customer);
	}

}
