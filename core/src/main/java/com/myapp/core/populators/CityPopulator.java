package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;

import com.myapp.core.beans.CityData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class CityPopulator implements Populator<CountrySubdivision, CityData>
{
	
	@Override
	public void populate(CountrySubdivision source, CityData target) throws ConvertionException 
	{
		target.setCode(source.getAbbreviation());
		target.setStateCode(source.getAlternateAbbreviation());
		target.setName(source.getName());
	}
	
}
