package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.Customer;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CustomerData;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.converter.Converter;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;
import com.myapp.core.user.MyCustomer;

public class CustomerPopulator implements Populator<MyCustomer, CustomerData> 
{
	private Converter<Area, AreaData> areaConverter;
	
	public Converter<Area, AreaData> getAreaConverter() {
		return areaConverter;
	}

	public void setAreaConverter(Converter<Area, AreaData> areaConverter) {
		this.areaConverter = areaConverter;
	}

	@Override
	public void populate(MyCustomer source, CustomerData target) throws ConvertionException 
	{
		Customer customer= (Customer)source;
		target.setId(customer.getId());
		target.setUserName(customer.getUsername());
		target.setFirstName(customer.getFirstName());
		target.setLastName(customer.getLastName());
		
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
