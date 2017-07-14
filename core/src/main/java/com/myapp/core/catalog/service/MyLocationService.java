package com.myapp.core.catalog.service;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;

public interface MyLocationService 
{
	List<State> getRegionsStartWith(String query);
	List<CountrySubdivision> getCitiesStartWith(String query);
}
