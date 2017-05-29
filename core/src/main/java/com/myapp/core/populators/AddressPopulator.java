package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.Address;

import com.myapp.core.beans.AddressData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class AddressPopulator implements Populator<Address, AddressData> 
{
	@SuppressWarnings("deprecation")
	@Override
	public void populate(Address source, AddressData target) throws ConvertionException 
	{
		target.setAddressLine1(source.getAddressLine1());
		target.setAddressLine2(source.getAddressLine2());
		target.setAddressLine3(source.getAddressLine3());
		target.setCity(source.getCity());
		target.setCompanyName(source.getCompanyName());
		target.setCountry(source.getCounty());
		target.setZipCode(source.getPostalCode());
		target.setPrimaryPhone(source.getPrimaryPhone());
		target.setSecondaryPhone(source.getSecondaryPhone());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmailAddress(source.getEmailAddress());
		target.setId(source.getId().toString());
	}

}
