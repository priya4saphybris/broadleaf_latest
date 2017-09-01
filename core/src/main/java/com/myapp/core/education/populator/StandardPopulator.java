package com.myapp.core.education.populator;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.StandardData;
import com.myapp.core.education.standard.Standard;
import com.myapp.core.populator.Populator;

public class StandardPopulator implements Populator<Standard, StandardData>
{

	@Override
	public void populate(Standard source, StandardData target) throws ConvertionException 
	{
		target.setCode(source.getCode());
		target.setId(source.getId());
		target.setDescription(source.getDescription());
		target.setName(source.getName());
	}

}
