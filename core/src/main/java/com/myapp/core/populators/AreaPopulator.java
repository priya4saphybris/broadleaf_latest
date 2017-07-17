package com.myapp.core.populators;

import com.myapp.core.beans.AreaData;
import com.myapp.core.catalog.model.Area;
import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.populator.Populator;

public class AreaPopulator implements Populator<Area, AreaData>
{

	@Override
	public void populate(Area source, AreaData target) throws ConvertionException 
	{
		target.setId(source.getId());
		target.setAreaCode(source.getAreaCode());
		target.setAreaName(source.getAreaName());
		target.setCityCode(source.getCityCode().getAbbreviation());
		target.setCityName(source.getCityCode().getName());
	}

}
