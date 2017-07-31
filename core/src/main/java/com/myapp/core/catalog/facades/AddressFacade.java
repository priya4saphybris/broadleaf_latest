package com.myapp.core.catalog.facades;

import org.broadleafcommerce.profile.core.domain.Address;

import com.myapp.core.beans.AddressData;

public interface AddressFacade 
{
	AddressData save(AddressData addressData);
	Address saveAddress(AddressData addressData);
}
