package com.myapp.core.education.populator;

import com.myapp.core.convertion.exception.ConvertionException;
import com.myapp.core.education.beans.StandardData;
import com.myapp.core.education.standard.Standard;
import com.myapp.core.populator.Populator;

public class StandardReversePopulator implements Populator<StandardData, Standard>
{

	@Override
	public void populate(StandardData source, Standard target) throws ConvertionException 
	{
		target.setCode(source.getCode());
		target.setDescription(source.getDescription());
		target.setId(source.getId());
		target.setName(source.getName());
	}
	
}
