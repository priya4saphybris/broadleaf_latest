package com.myapp.core.catalog.beans;

import java.util.List;

public class FacetBasicValueData extends AbstractFacetValueData
{
	private List<FacetValueData> values;

	public List<FacetValueData> getValues() {
		return values;
	}

	public void setValues(List<FacetValueData> values) {
		this.values = values;
	}
}
