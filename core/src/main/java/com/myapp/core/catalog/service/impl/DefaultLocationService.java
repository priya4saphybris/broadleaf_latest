package com.myapp.core.catalog.service.impl;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;

import com.myapp.core.catalog.dao.MyLocationDao;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.service.MyLocationService;

public class DefaultLocationService implements MyLocationService
{
	private MyLocationDao myLocationDao;
	

	public MyLocationDao getMyLocationDao() {
		return myLocationDao;
	}

	public void setMyLocationDao(MyLocationDao myLocationDao) {
		this.myLocationDao = myLocationDao;
	}

	@Override
	public List<State> getRegionsStartWith(String query) 
	{
		return myLocationDao.getRegionsStartWith(query);
	}

	@Override
	public List<CountrySubdivision> getCitiesStartWith(String query) 
	{
		return myLocationDao.getCitiesStartWith(query);
	}

	@Override
	public List<Area> getAllAreas() 
	{
		return myLocationDao.getAllAreas();
	}

	@Override
	public List<Area> getAllAreasForCity(String cityCode) 
	{
		return myLocationDao.getAllAreasForCity(cityCode);
	}

	@Override
	public Area findArea(String areaCode) 
	{
		return myLocationDao.findArea(areaCode);
	}

}
