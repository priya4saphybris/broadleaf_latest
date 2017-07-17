package com.myapp.core.catalog.facades.impl;

import java.util.List;

import com.myapp.core.catalog.facades.MyServicesFacade;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.catalog.service.MyServicesService;

public class DefaultServicesFacade implements MyServicesFacade
{
	private MyServicesService myServicesService;
	
	public MyServicesService getMyServicesService() {
		return myServicesService;
	}


	public void setMyServicesService(MyServicesService myServicesService) {
		this.myServicesService = myServicesService;
	}


	@Override
	public List<Area> getServicesForCity(String areaCode) 
	{
		return null;
	}
	
}
