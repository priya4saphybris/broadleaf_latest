package com.myapp.core.populators;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.StateService;

import com.myapp.core.beans.LocationSelectionData;
import com.myapp.core.catalog.model.LocationSelection;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class LocationSelectionPopulator implements Populator<LocationSelection, LocationSelectionData>
{
	
	@Resource(name="blCountrySubdivisionService")
	private CountrySubdivisionService countrySubdivisionService;
	
	@Resource(name="blStateService")
	private StateService stateService;
	
	
	public CountrySubdivisionService getCountrySubdivisionService() {
		return countrySubdivisionService;
	}


	public void setCountrySubdivisionService(CountrySubdivisionService countrySubdivisionService) {
		this.countrySubdivisionService = countrySubdivisionService;
	}


	public StateService getStateService() {
		return stateService;
	}


	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}


	@Override
	public void populate(LocationSelection source, LocationSelectionData target) throws ConvertionException 
	{
			CountrySubdivision countrySubdivision=countrySubdivisionService.findSubdivisionByAbbreviation(source.getCityCode());
			
			if(null != countrySubdivision)
			{
				target.setCityCode(source.getCityCode());
				target.setCityName(countrySubdivision.getName());
			}
			
			State state=stateService.findStateByAbbreviation(target.getStateCode());
			
			if(null != state)
			{
				target.setStateCode(state.getName());
				target.setStateName(state.getName());
			}
			
	}
	
}
