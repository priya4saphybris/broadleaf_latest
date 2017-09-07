package com.myapp.core.catalog.facades.impl;

import java.util.List;

import javax.annotation.Resource;

import org.broadleafcommerce.cms.file.domain.StaticAsset;
import org.broadleafcommerce.cms.file.service.StaticAssetService;

import com.myapp.core.catalog.beans.BannersData;
import com.myapp.core.catalog.facades.StaticAssetFacade;
import com.myapp.core.converter.Converter;

public class DefaultStaticAssetFacade implements StaticAssetFacade
{
	@Resource(name="blStaticAssetService")
	private StaticAssetService staticAssetService;
	
	Converter<StaticAsset, BannersData> assetConverter;
	
	
	public Converter<StaticAsset, BannersData> getAssetConverter() {
		return assetConverter;
	}


	public void setAssetConverter(Converter<StaticAsset, BannersData> assetConverter) {
		this.assetConverter = assetConverter;
	}


	public StaticAssetService getStaticAssetService() {
		return staticAssetService;
	}


	public void setStaticAssetService(StaticAssetService staticAssetService) {
		this.staticAssetService = staticAssetService;
	}


	@Override
	public List<BannersData> readAllAssets() 
	{
		List<StaticAsset> staticAssets=staticAssetService.readAllStaticAssets();
		List<BannersData> banners=assetConverter.convertAll(staticAssets);
		return banners;
	}

}
