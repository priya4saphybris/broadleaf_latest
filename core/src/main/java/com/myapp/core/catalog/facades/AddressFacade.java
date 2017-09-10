package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.AddressData;

public interface AddressFacade 
{
	AddressData save(AddressData addressData);
	AddressData update(AddressData addressData);
	List<AddressData> getCustomerAddresses(Long customerid);
	AddressData getCutomerDefaultAddress(Long customerid);
	List<AddressData> getDeleteAddresses(Long customerAddressId, Long addressId);
	List<AddressData> makeDefaultAddress(Long customerId, Long addressId);
}
