package com.mycompany.api.data.utils;

import com.myapp.core.beans.AddressData;
import com.mycompany.api.customer.response.AddressResponse;

public class AddressDataUtil 
{
	public static boolean validate(AddressData addressData, AddressResponse response)
	{
		if(null == addressData)
		{
			response.setErrorMessage("Address data should be present");
			return true;
		}
		
		if(null == addressData.getAddressLine1())
		{
			response.setErrorMessage("Address line1 should be present");
			return true;
		}
		
		if(null == addressData.getAddressLine2())
		{
			response.setErrorMessage("Address line2 should be present");
			return true;
		}
		
		if(null == addressData.getZipCode())
		{
			response.setErrorMessage("Address zipcode should be present");
			return true;
		}
		
		if(null == addressData.getCity())
		{
			response.setErrorMessage("Address city should be present");
			return true;
		}
		
		return false;
	}
}
