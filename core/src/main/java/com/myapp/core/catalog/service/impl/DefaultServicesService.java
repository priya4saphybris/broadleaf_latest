package com.myapp.core.catalog.service.impl;

import java.util.List;

import com.myapp.core.catalog.dao.MyServicesDao;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.model.Services;
import com.myapp.core.catalog.service.MyServicesService;

public class DefaultServicesService implements MyServicesService
{
	private MyServicesDao myServicesDao;
	
	public MyServicesDao getMyServicesDao() {
		return myServicesDao;
	}

	public void setMyServicesDao(MyServicesDao myServicesDao) {
		this.myServicesDao = myServicesDao;
	}

	@Override
	public Services getServicesForCity(String areaCode) 
	{
		if(null != myServicesDao.getServicesForCity(areaCode))
		{
			Services services= myServicesDao.getServicesForCity(areaCode).get(0);
			return services;
		}
		return null;
	}
	
}
