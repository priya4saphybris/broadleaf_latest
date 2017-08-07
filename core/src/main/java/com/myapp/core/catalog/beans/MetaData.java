package com.myapp.core.catalog.beans;

public class MetaData 
{
	private LinkData links;
	private FacetData filters;
	private String sorting;
	private int recordsCount;
	
	public LinkData getLinks() {
		return links;
	}

	public void setLinks(LinkData links) {
		this.links = links;
	}

	public FacetData getFilters() {
		return filters;
	}

	public void setFilters(FacetData filters) {
		this.filters = filters;
	}

	public String getSorting() {
		return sorting;
	}

	public void setSorting(String sorting) {
		this.sorting = sorting;
	}

	public int getRecordsCount() {
		return recordsCount;
	}

	public void setRecordsCount(int recordsCount) {
		this.recordsCount = recordsCount;
	}
	
}
