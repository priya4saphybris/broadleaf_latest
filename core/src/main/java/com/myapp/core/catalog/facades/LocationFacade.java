package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.AreaData;
import com.myapp.core.beans.CurrentLocationData;
import com.myapp.core.beans.LocationData;
import com.myapp.core.beans.RegionData;

public interface LocationFacade 
{
	RegionData getRegionByCode(String code);
	List<RegionData> getAllRegions();
	List<RegionData> getRegionsStartWith(String query);
	List<LocationData> getCitiesStartWith(String query);
	List<AreaData> getAllAreas();
	LocationData getAllAreasForCity(String cityCode);
	void selectLocation(CurrentLocationData currentLocation);
	AreaData findArea(String areaCode);
}
