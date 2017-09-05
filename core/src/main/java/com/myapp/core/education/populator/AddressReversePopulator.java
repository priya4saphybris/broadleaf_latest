package com.myapp.core.education.populator;

import org.broadleafcommerce.profile.core.domain.Address;

import com.myapp.core.beans.AddressData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class AddressReversePopulator implements Populator<AddressData, Address>
{

	@Override
	public void populate(AddressData addressData, Address address) throws ConvertionException 
	{
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
	}

}
