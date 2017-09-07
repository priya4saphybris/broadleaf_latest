package com.myapp.core.catalog.facades;

import java.util.List;

import com.myapp.core.catalog.beans.BannersData;

public interface StaticAssetFacade 
{
	public List<BannersData> readAllAssets();
}
