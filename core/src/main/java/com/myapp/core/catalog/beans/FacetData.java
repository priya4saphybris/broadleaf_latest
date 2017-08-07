package com.myapp.core.catalog.beans;

import java.util.List;

public class FacetData 
{
	private List<AbstractFacetValueData> filters;

	public List<AbstractFacetValueData> getFilters() 
	{
		return filters;
	}

	public void setFilters(List<AbstractFacetValueData> filters) 
	{
		this.filters = filters;
	}
}
