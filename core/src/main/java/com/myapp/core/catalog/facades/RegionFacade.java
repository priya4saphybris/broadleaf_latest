package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.beans.RegionData;


public interface RegionFacade 
{
	RegionData getRegionByCode(String code);
	List<RegionData> getAllRegions();
}
