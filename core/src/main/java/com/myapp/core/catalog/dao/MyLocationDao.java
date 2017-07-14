package com.myapp.core.catalog.dao;

import java.util.List;

import org.broadleafcommerce.profile.core.domain.CountrySubdivision;
import org.broadleafcommerce.profile.core.domain.State;

public interface MyLocationDao 
{
	List<State> getRegionsStartWith(String query);
	List<CountrySubdivision> getCitiesStartWith(String query);
}
