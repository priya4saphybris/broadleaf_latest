package com.myapp.core.catalog.beans;

import java.util.List;

import com.myapp.core.beans.CategoryData;

public class HomePageData 
{
	private MetaData metaData;
	private List<CategoryData> records;
	private List<BannersData> banners;
	public MetaData getMetaData() {
		return metaData;
	}
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	public List<CategoryData> getRecords() {
		return records;
	}
	public void setRecords(List<CategoryData> records) {
		this.records = records;
	}
	public List<BannersData> getBanners() {
		return banners;
	}
	public void setBanners(List<BannersData> banners) {
		this.banners = banners;
	}
	
}
