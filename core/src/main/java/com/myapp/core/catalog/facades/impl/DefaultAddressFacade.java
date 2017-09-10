package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.springframework.util.CollectionUtils;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.myapp.core.converter.Converter;
import com.myapp.core.education.populator.AddressReversePopulator;

public class DefaultAddressFacade implements AddressFacade
{
	@Resource(name="blAddressService")
	private AddressService addressService;
	
	@Resource(name = "blCustomerAddressService")
	protected CustomerAddressService customerAddressService;
	
	private Converter<Address, AddressData> addressConverter;
	
	private AddressReversePopulator addressReversePopulator;
	
	@Resource(name="blCustomerService")
	private CustomerService customerService;
	
	public CustomerAddressService getCustomerAddressService() {
		return customerAddressService;
	}

	public void setCustomerAddressService(CustomerAddressService customerAddressService) {
		this.customerAddressService = customerAddressService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public AddressReversePopulator getAddressReversePopulator() {
		return addressReversePopulator;
	}

	public void setAddressReversePopulator(AddressReversePopulator addressReversePopulator) {
		this.addressReversePopulator = addressReversePopulator;
	}

	public Converter<Address, AddressData> getAddressConverter() {
		return addressConverter;
	}

	public void setAddressConverter(Converter<Address, AddressData> addressConverter) {
		this.addressConverter = addressConverter;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	@Override
	public AddressData save(AddressData addressData) 
	{
		Address updatedAddress=saveAddress(addressData);
		return addressConverter.convert(updatedAddress);
	}
	
	private Address saveAddress(AddressData addressData)
	{
		Address address= new AddressImpl();
		addressReversePopulator.populate(addressData, address);
		address=addressService.saveAddress(address);
		CustomerAddress customerAddress=customerAddressService.create();
		customerAddress.setAddress(address);
		customerAddress.setAddressName("Customer Address");
		customerAddress.setCustomer(customerService.readCustomerById(addressData.getCustomerId()));
		customerAddress = this.customerAddressService.saveCustomerAddress(customerAddress);
		return address;
	}

	@Override
	public AddressData update(AddressData addressData) 
	{
		CustomerAddress customerAddress=getCustomerAddress(addressData.getCustomerId(), Long.valueOf(addressData.getId()));
		CustomerAddress address=customerAddressService.saveCustomerAddress(customerAddress);
		return addressConverter.convert(address.getAddress());
	}
	
	@Override
	public List<AddressData> getCustomerAddresses(Long customerid) 
	{
		List<CustomerAddress> addressList=customerAddressService.readActiveCustomerAddressesByCustomerId(customerid);
		
		List<AddressData> adresses= new ArrayList<AddressData>();
		
		if(!CollectionUtils.isEmpty(addressList))
		{
			for(CustomerAddress customerAddress: addressList)
			{
				Address address= customerAddress.getAddress();
				
				if(null != address)
				{
					adresses.add(addressConverter.convert(address));
				}
			}
		}
		return adresses;
	}
	
	@Override
	public AddressData getCutomerDefaultAddress(Long customerid)
	{
		CustomerAddress customerAddress=customerAddressService.findDefaultCustomerAddress(customerid);
		
		if(null!=customerAddress)
		{
			return addressConverter.convert(customerAddress.getAddress());
		}
		return null;
	}

	@Override
	public List<AddressData> getDeleteAddresses(Long customerId, Long addressId) 
	{
		
		CustomerAddress customerAddress=getCustomerAddress(customerId,addressId);
		
		if(null != customerAddress)
		{
			customerAddressService.deleteCustomerAddressById(customerAddress.getId());
		}
		
		return getCustomerAddresses(customerId);
	}
	
	@Override
	public List<AddressData> makeDefaultAddress(Long customerId, Long addressId)
	{
		CustomerAddress customerAddress=getCustomerAddress(customerId,addressId);
		
		if(null != customerAddress)
		{
			customerAddressService.makeCustomerAddressDefault(customerId, customerAddress.getId());
		}
		return getCustomerAddresses(customerId);
	}
	
	private CustomerAddress getCustomerAddress(Long customerId, Long addressid)
	{
		List<CustomerAddress> addressList=customerAddressService.readActiveCustomerAddressesByCustomerId(customerId);
		if(!CollectionUtils.isEmpty(addressList))
		{
			for(CustomerAddress customerAddress: addressList)
			{
				Address address= customerAddress.getAddress();
				if(address.getId()==addressid)
				{
					return customerAddress;
				}
			}
		}
		return null;
	}

}
