package com.myapp.core.catalog.service.impl;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.myapp.core.catalog.dao.MyServicesDao;
import com.myapp.core.catalog.model.Services;
import com.myapp.core.catalog.model.ServicesCategoryXref;
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
	public List<ServicesCategoryXref> getServicesForArea(String areaCode) 
	{
		List<Services> servicesList=myServicesDao.getServicesForArea(areaCode);
		if(null != servicesList && !CollectionUtils.isEmpty(servicesList))
		{
			Services services= (Services)servicesList.get(0);
			return services.getAvailableCategories();
		}
		return null;
	}
	
}
