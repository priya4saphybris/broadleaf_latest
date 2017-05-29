package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.beans.CustomerData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class CustomerPopulator implements Populator<Customer, CustomerData> 
{

	@Override
	public void populate(Customer source, CustomerData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setUserName(source.getUsername());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
	}

}
