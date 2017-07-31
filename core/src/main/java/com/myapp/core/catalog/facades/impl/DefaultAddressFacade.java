package com.myapp.core.catalog.facades.impl;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.service.AddressService;

import com.myapp.core.beans.AddressData;
import com.myapp.core.catalog.facades.AddressFacade;
import com.myapp.core.converter.Converter;

public class DefaultAddressFacade implements AddressFacade
{
	@Resource(name="blAddressService")
	private AddressService addressService;
	
	private Converter<Address, AddressData> addressConverter;
	
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

	@Override
	public Address saveAddress(AddressData addressData)
	{
		Address address= new AddressImpl();
		address.setAddressLine1(addressData.getAddressLine1());
		address.setAddressLine2(addressData.getAddressLine2());
		address.setAddressLine3(addressData.getAddressLine3());
		address.setDefault(addressData.isDefault());
		address.setEmailAddress(addressData.getEmailAddress());
		address.setFullName(addressData.getFirstName());
		address.setLastName(addressData.getLastName());
		address.setPrimaryPhone(addressData.getPrimaryPhone());
		address.setSecondaryPhone(addressData.getSecondaryPhone());
		address.setCity(addressData.getCity());
		address.setPostalCode(addressData.getZipCode());
		return addressService.saveAddress(address);
	}
}
