package com.myapp.core.populators;

import org.broadleafcommerce.cms.file.domain.StaticAsset;

import com.myapp.core.catalog.beans.BannersData;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class AssetPopulator implements Populator<StaticAsset, BannersData>
{

	@Override
	public void populate(StaticAsset source, BannersData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setCatgeory(Long.valueOf(source.getName()));
		target.setUrl(source.getFullUrl());
	}
	
}
