package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;

import com.myapp.core.beans.AreaData;
import com.myapp.core.catalog.model.Area;

public interface MyLocationService 
{
	List<State> getRegionsStartWith(String query);
	List<CountrySubdivision> getCitiesStartWith(String query);
	List<Area> getAllAreas();
	List<Area> getAllAreasForCity(String cityCode);
	Area findArea(String areaCode);
}
