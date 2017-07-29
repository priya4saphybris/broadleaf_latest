package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.converter.Converter;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;
import com.myapp.core.user.MyCustomer;

public class CustomerPopulator implements Populator<Customer, CustomerData> 
{
	private Converter<Area, AreaData> areaConverter;
	
	public Converter<Area, AreaData> getAreaConverter() {
		return areaConverter;
	}

	public void setAreaConverter(Converter<Area, AreaData> areaConverter) {
		this.areaConverter = areaConverter;
	}

	@Override
	public void populate(Customer source, CustomerData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setUserName(source.getUsername());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		
		if(source instanceof MyCustomer)
		{
			MyCustomer myCustomer= (MyCustomer)source;
			
			if(null != myCustomer.getArea())
			{
				AreaData areaData=areaConverter.convert(myCustomer.getArea());
				target.setAreaData(areaData);
			}
		}
	}

}
