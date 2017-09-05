package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.AddressData;

public interface AddressFacade 
{
	AddressData save(AddressData addressData);
	List<AddressData> getCustomerAddresses(Long customerid);
}
