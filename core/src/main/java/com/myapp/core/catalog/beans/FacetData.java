package com.myapp.core.catalog.beans;

import java.util.List;

public class FacetData 
{
	private List<FacetValueData> filters;

	public List<FacetValueData> getFilters() {
		return filters;
	}

	public void setFilters(List<FacetValueData> filters) {
		this.filters = filters;
	}
	
}
