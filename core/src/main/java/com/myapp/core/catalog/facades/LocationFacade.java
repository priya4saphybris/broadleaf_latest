package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CityData;
import com.myapp.core.beans.RegionData;

public interface LocationFacade 
{
	RegionData getRegionByCode(String code);
	List<RegionData> getAllRegions();
	List<RegionData> getRegionsStartWith(String query);
	List<CityData> getCitiesStartWith(String query);
	List<AreaData> getAllAreas();
	List<AreaData> getAllAreasForCity(String cityCode);
}
