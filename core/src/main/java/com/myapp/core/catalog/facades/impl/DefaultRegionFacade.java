package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.service.StateService;

import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.RegionFacade;
import com.myapp.core.converter.Converter;


public class DefaultRegionFacade implements RegionFacade
{
	@Resource(name="blStateService")
	private StateService stateService;
	
	private Converter<State, RegionData> regionConverter;
	
	
	public Converter<State, RegionData> getRegionConverter() {
		return regionConverter;
	}

	public void setRegionConverter(Converter<State, RegionData> regionConverter) {
		this.regionConverter = regionConverter;
	}

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	@Override
	public RegionData getRegionByCode(String code) 
	{
		State state=stateService.findStateByAbbreviation(code);
		return regionConverter.convert(state);
	}

	
	@Override
	public List<RegionData> getAllRegions() 
	{
		List<State> states=stateService.findStates();
		List<RegionData> regions= new ArrayList<RegionData>();
		for(State state: states)
		{
			regions.add(regionConverter.convert(state));
		}
		return regions;
	}
	
}
