package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;

import com.myapp.core.beans.LocationData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class CityPopulator implements Populator<CountrySubdivision, LocationData>
{
	
	@Override
	public void populate(CountrySubdivision source, LocationData target) throws ConvertionException 
	{
		target.setCityCode(source.getAbbreviation());
		target.setStateCode(source.getAlternateAbbreviation());
		target.setCityName(source.getName());
	}
	
}
