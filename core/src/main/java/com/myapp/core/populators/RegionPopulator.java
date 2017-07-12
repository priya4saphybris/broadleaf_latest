package com.myapp.core.populators;

import org.broadleafcommerce.profile.core.domain.State;

import com.myapp.core.beans.RegionData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class RegionPopulator implements Populator<State, RegionData>
{
	
	@Override
	public void populate(State source, RegionData target) throws ConvertionException 
	{
		target.setCode(source.getAbbreviation());
		target.setCountryCode(source.getCountry().getAbbreviation());
		target.setName(source.getName());
	}
}
