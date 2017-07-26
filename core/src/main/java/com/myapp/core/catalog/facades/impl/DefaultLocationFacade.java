package com.myapp.core.catalog.facades.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;
import org.broadleafcommerce.profile.core.service.StateService;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CityData;
import com.myapp.core.beans.RegionData;
import com.myapp.core.catalog.facades.LocationFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.service.MyLocationService;
import com.myapp.core.converter.Converter;


public class DefaultLocationFacade implements LocationFacade
{
	@Resource(name="blStateService")
	private StateService stateService;
	
	private MyLocationService myLocationService;
	
	private Converter<State, RegionData> regionConverter;
	
	private Converter<CountrySubdivision, CityData> citiConverter;
	
	private Converter<Area, AreaData> areaConverter;
	
	public Converter<Area, AreaData> getAreaConverter() {
		return areaConverter;
	}

	public void setAreaConverter(Converter<Area, AreaData> areaConverter) {
		this.areaConverter = areaConverter;
	}

	public StateService getStateService() {
		return stateService;
	}

	public void setStateService(StateService stateService) {
		this.stateService = stateService;
	}

	public MyLocationService getMyLocationService() {
		return myLocationService;
	}

	public void setMyLocationService(MyLocationService myLocationService) {
		this.myLocationService = myLocationService;
	}

	public Converter<State, RegionData> getRegionConverter() {
		return regionConverter;
	}

	public void setRegionConverter(Converter<State, RegionData> regionConverter) {
		this.regionConverter = regionConverter;
	}

	public Converter<CountrySubdivision, CityData> getCitiConverter() {
		return citiConverter;
	}

	public void setCitiConverter(Converter<CountrySubdivision, CityData> citiConverter) {
		this.citiConverter = citiConverter;
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

	@Override
	public List<RegionData> getRegionsStartWith(String query) {
		// TODO Auto-generated method stub
		List<State> states=myLocationService.getRegionsStartWith(query);
		List<RegionData> regions= new ArrayList<RegionData>();
		for(State state: states)
		{
			regions.add(regionConverter.convert(state));
		}
		return regions;
	}

	@Override
	public List<CityData> getCitiesStartWith(String query) 
	{
		List<CountrySubdivision> cities=myLocationService.getCitiesStartWith(query);
		List<CityData> cityList= new ArrayList<CityData>();
		for(CountrySubdivision city: cities)
		{
			cityList.add(citiConverter.convert(city));
		}
		return cityList;
	}
	
	public List<AreaData> getAllAreas()
	{
		List<Area> areas=myLocationService.getAllAreas();
		List<AreaData> areaDataList= new ArrayList<AreaData>();
		
		for(Area area: areas)
		{
			areaDataList.add(areaConverter.convert(area));
		}
		return areaDataList;
	}

	@Override
	public List<AreaData> getAllAreasForCity(String cityCode) 
	{
		List<Area> areas=myLocationService.getAllAreasForCity(cityCode);
		List<AreaData> areaDataList= new ArrayList<AreaData>();
		
		for(Area area: areas)
		{
			areaDataList.add(areaConverter.convert(area));
		}
		return areaDataList;
	}
	
	
}
