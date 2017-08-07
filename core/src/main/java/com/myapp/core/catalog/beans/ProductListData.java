package com.myapp.core.catalog.beans;

import java.util.List;

public class ProductListData 
{
	private MetaData metaData;
	private List<ProductItemData> records;
	
	public MetaData getMetaData() 
	{
		return metaData;
	}
	public void setMetaData(MetaData metaData) 
	{
		this.metaData = metaData;
	}
	public List<ProductItemData> getRecords() 
	{
		return records;
	}
	public void setRecords(List<ProductItemData> records) 
	{
		this.records = records;
	}
}
